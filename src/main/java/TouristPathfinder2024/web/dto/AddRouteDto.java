package TouristPathfinder2024.web.dto;

import TouristPathfinder2024.model.UserLevel;

public class AddRouteDto {

    private String name;
    private String description;
    private String coordinates;
    private String videoUrl;
    private UserLevel level;

    public AddRouteDto() {
    }

    public String getName() {
        return name;
    }

    public AddRouteDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddRouteDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public AddRouteDto setCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public AddRouteDto setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserLevel getLevel() {
        return level;
    }

    public AddRouteDto setLevel(UserLevel level) {
        this.level = level;
        return this;
    }
}
