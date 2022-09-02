package test1;

import java.io.ByteArrayInputStream;
import java.util.*;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Sets;
import com.google.gson.*;

public class zztest {
    public static Map<String, Object> main(String[] args) throws Exception {

            // 新站从库读账号
//            DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://10.130.84.50:6327/ecom_ads_publish?useUnicode=true&characterEncoding=utf-8&useSSL=false&zeroDateTimeBehavior=convertToNull&autoReconnect=true",
//                    "rw_shopline_test", "48IZ9FN66vk56WFXrnf848qf"
//            );
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//            Map<String, Object> map = jdbcTemplate.queryForMap("" +
//                    "select t.refresh_token,t.token,o.client_id,o.client_secret from ecom_gg_gmc_oauth_account t " +
//                    "left join ecom_gg_oauth_token o on t.token_id=o.id " +
//                    "where t.id = (select gmc_oauth_account_id from ecom_gg_gmc_account where account_id ='320841617' and `source` = 'oauth')");
//            Object tokenJson = map.remove("token");
//            Gson gson = new Gson();
//            Map<String, Object> tokenMap = gson.fromJson(tokenJson.toString(), new TypeToken<Map<String, Object>>() {
//            }.getType());
//
//            String idToken = (String) tokenMap.get("idToken");
//            System.out.println(idToken);
            Gson gson = new Gson();

            Map<String, Object> map = new HashMap<String, Object>();
            String idToken1 = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjQwMmYzMDViNzA1ODEzMjlmZjI4OWI1YjNhNjcyODM4MDZlY2E4OTMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxMDY4OTQwOTA1NzQxLWkwcG5qbmE1dGZrcXF1bGFkZnJzc3NiNnV2bTB0a3YzLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTA2ODk0MDkwNTc0MS1pMHBuam5hNXRma3FxdWxhZGZyc3NzYjZ1dm0wdGt2My5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjExMDM0OTM2NTI4OTM1OTUxMDk4NSIsImVtYWlsIjoic3l6dHRlc3QwNEBnbWFpbC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6IkdDdXpERGhTZlNhWk94YlhrRm9JVUEiLCJuYW1lIjoi5ZWG5LitMDQiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUl0YnZta1dPOHZna2thenI2N25ja0VKZ09WU2RjWmQxanlJNlZYZ0xSMmc9czk2LWMiLCJnaXZlbl9uYW1lIjoiMDQiLCJmYW1pbHlfbmFtZSI6IuWVhuS4rSIsImxvY2FsZSI6InpoLUNOIiwiaWF0IjoxNjYxMzk2MzU4LCJleHAiOjE2NjEzOTk5NTh9.BsQRbNM_SGqekO-Xy-tjdXiS6azjRDskFofn4tyYFc2wBuzVLJpB3P1K6cPFIea80hOGpP71iBGhgxCYABbhGrpHRkP97FU-aSnn3vc07qac46mdKXtIopMSuind2iovP3ftEH7Q5RvgOTfjO1VfVHeoK0uCGdZqRvuAlYRH2lirrvfCO27t400Bvup1dTo84teL-uFSVuNK6vd3jJgAeRxWDQ15ZqVZyK2zN_ML0j5-tVw1-X_zoC78e_AOrn8HDMbK9PL6QQkry_yNvUKDlq7-P5HJnXA1QrYxTdUTCUIK_Qi1_nx7JLKYhYWTHtlJuew0JLmPdp7-ocRzhEofOg";
            map.put("type", "authorized_user");
            map.put("token_type", "Bearer");
            map.put("idToken", idToken1);
            map.put("refresh_token","1//0exUEKl4aD0rGCgYIARAAGA4SNwF-L9IrtNr82Gp1RAMv7WT-nkl7qc71xAKsBp7EYVFLTbnF2c4AyzDcnoD1uRJU2gJW-_b3JQA");
            map.put("client_id","1068940905741-i0pnjna5tfkqquladfrsssb6uvm0tkv3.apps.googleusercontent.com");
            map.put("client_secret","AZrisx7cWRKQb2VdN8BA_e0_");
            String json = gson.toJson(map);
            System.out.println(json);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(json.getBytes());
            Set<String> scopes = Sets.newHashSet("https://www.googleapis.com/auth/content");
            SslUtils.ignoreSsl();
            GoogleCredentials credentials = GoogleCredentials.fromStream(byteArrayInputStream).createScoped(scopes);
            AccessToken accessToken = credentials.refreshAccessToken();
            System.out.println(accessToken.getTokenValue());

            Map<String, Object> resultMap = new HashMap<>(4);
            resultMap.put("accessToken", accessToken.getTokenValue());
            //resultMap.put("expireTime", DateUtil.formatDateTime(accessToken.getExpirationTime()));
            return resultMap;
        }

}