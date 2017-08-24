package model.ServiceabilityModel;

/**
 * Created by Rami9 on 12/06/2017.
 */
public class Link {
    private String href;
    private String rel;
    private String method;
    private String type;
    private String id;

    public Link(String href, String rel, String method, String type, String id) {
        this.href = href;
        this.rel = rel;
        this.method = method;
        this.type = type;
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
