package TouristPathfinder2024.model.dto;

public class RouteShortInfoDto {

    private long id;

    private String name;
    private String description;
    private String imagUrl;

    public RouteShortInfoDto() {
    }

    public long getId() {
        return id;
    }

    public RouteShortInfoDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteShortInfoDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteShortInfoDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImagUrl() {
        return imagUrl;
    }

    public RouteShortInfoDto setImagUrl(String imagUrl) {
        this.imagUrl = imagUrl;
        return this;
    }
}
