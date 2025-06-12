package peng.zhi.liu.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JWT {
    private final static String SECRET_KEY="pengzhiliu";
    //生成令牌
    public static String generateJWT(Map<String,Object> claims){
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+1000*3600*12))
                .compact();
        return token;
    }

    //解析令牌
    public static Claims parseJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
