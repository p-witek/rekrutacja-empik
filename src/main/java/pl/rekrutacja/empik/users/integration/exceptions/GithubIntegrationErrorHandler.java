package pl.rekrutacja.empik.users.integration.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class GithubIntegrationErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError());
    }

    @Override
    protected void handleError(ClientHttpResponse response, HttpStatusCode statusCode) throws IOException {
        if (statusCode.is5xxServerError()) {
            throw new IntegrationException("Service temporarily unavailable. Try again later.");
        }
        if (statusCode.is4xxClientError()) {
            throw new IntegrationException("User not found");
        }
    }
}
