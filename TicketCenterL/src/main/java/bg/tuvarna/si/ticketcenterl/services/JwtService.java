package bg.tuvarna.si.ticketcenterl.services;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    public static String jwtSecret = "ni24g6hk5ba5a65a6x6s2c6c6s2";
    private static int jwtExpirationMs = 36000000;

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        Claims claims=null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(jwtSecret.getBytes())  // Using secretKey directly
                    .parseClaimsJws(token)  // Correct method to parse JWS tokens
                    .getBody();
        }
        catch (ExpiredJwtException e){
            throw new RuntimeException(e);
        }
        catch (UnsupportedJwtException e){
            throw new RuntimeException(e);
        }
        catch (MalformedJwtException e){
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }
        return claims;
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }


    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    public String generateRefreshToken(UserDetails userDetails){
        return createToken(new HashMap<>(),userDetails.getUsername());
    }

    private String createToken(Map<String, Object>claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
    }


    public Boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
