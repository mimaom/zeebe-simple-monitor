package io.zeebe.monitor.config;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProvider;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProviderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZeebeClientConfig {

    @Value("${zeebe.client.id}")
    private String clientId;

    @Value("${zeebe.client.secret}")
    private String clientSecret;

    @Value("${zeebe.client.authorizationServerUrl}")
    private String authorizationServerUrl;

    @Value("${zeebe.client.audience}")
    private String audience;

    @Value("${zeebe.gateway.address}")
    private String gatewayAddress;

    @Bean
    public ZeebeClient zeebeClient(){
        OAuthCredentialsProvider provider =
//                new OAuthCredentialsProviderBuilder()
//                        .clientId("customer-client")
//                        .clientSecret("cHcxSaHU2WtYq0798PqmSjkklG2a2xU9")
//                        .authorizationServerUrl("https://core.openflow-test.openminds.dk/realms/customer/protocol/openid-connect/token")
//                        .audience("openflow-test.openminds.dk")
//                        .build();
                new OAuthCredentialsProviderBuilder()
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .authorizationServerUrl(authorizationServerUrl)
                        .audience(audience)
                        .build();

        return ZeebeClient.newClientBuilder().gatewayAddress(gatewayAddress).usePlaintext().build();
    }

}
