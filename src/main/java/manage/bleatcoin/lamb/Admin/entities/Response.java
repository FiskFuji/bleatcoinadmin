package manage.bleatcoin.lamb.Admin.entities;

import java.util.Objects;

public class Response {
    private boolean error;
    private String message;

    public Response(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return isError() == response.isError() &&
                Objects.equals(getMessage(), response.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isError(), getMessage());
    }
}
