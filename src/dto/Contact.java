package dto;

public class Contact {
    private String type;
    private String detail;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Contact{" +
            "type='" + type + '\'' +
            ", detail='" + detail + '\'' +
            '}';
    }
}
