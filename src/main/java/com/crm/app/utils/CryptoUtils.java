package com.crm.app.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

public class CryptoUtils {
	public static String SECRET_KEY;
	public static String BASE_SECRET_URL;
	
	public static String extractInput(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private static Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public static String generateToken(String input){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, input);
    }

    private static String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static Boolean validateToken(String token, String plainInput){
        final String input = extractInput(token);

        return (input.equals(plainInput) && !isTokenExpired(token));
    }
    
    public static Long extractCompanyId(String token) throws RuntimeException {
    	try {
    		String idString = extractInput(token);
    		if(idString != null && !idString.isEmpty())
    			return StaticUtils.parseLong(idString);
			
		} catch(MalformedJwtException mje) {
        	mje.printStackTrace();
        	throw new RuntimeException("malformed token");
        	
        } catch(ExpiredJwtException eje) {
        	eje.printStackTrace();
        	throw new RuntimeException("expired token");
        	
        } catch(Exception e) {
        	e.printStackTrace();
        	throw new RuntimeException("invalid jwt token");
        }
    	
    	return null;
    }
    
    public static boolean isValid(String token, String plainInput) throws RuntimeException {
    	try {
    		Boolean status = validateToken(token, plainInput);
    		if(status != null)
    			return status;
			
		} catch(MalformedJwtException mje) {
        	mje.printStackTrace();
        	throw new RuntimeException("malformed token");
        	
        } catch(ExpiredJwtException eje) {
        	eje.printStackTrace();
        	throw new RuntimeException("expired token");
        	
        } catch(Exception e) {
        	e.printStackTrace();
        	throw new RuntimeException("invalid jwt token");
        }
    	
    	return false;
    }
    
    public static String generateToken(Long companyId) {
    	return generateToken("" + companyId);
    }
    
    public static String generateUrl(Long companyId) {
    	return BASE_SECRET_URL + generateToken(companyId);
    }
}
