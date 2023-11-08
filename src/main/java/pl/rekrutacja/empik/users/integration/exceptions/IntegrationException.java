package pl.rekrutacja.empik.users.integration.exceptions;

public class IntegrationException extends RuntimeException {

    IntegrationException(String errorMessage) {
        super(errorMessage);
    }
}
