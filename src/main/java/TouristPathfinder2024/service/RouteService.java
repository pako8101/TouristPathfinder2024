package TouristPathfinder2024.service;

import TouristPathfinder2024.data.RouteRepository;
import TouristPathfinder2024.data.UserRepository;
import TouristPathfinder2024.model.Picture;
import TouristPathfinder2024.model.Route;
import TouristPathfinder2024.model.dto.RouteShortInfoDto;
import TouristPathfinder2024.web.dto.AddRouteDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;
    private final Random random;
    private final ModelMapper modelMapper;

    public RouteService(UserRepository userRepository, RouteRepository routeRepository) {
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();
        this.random = new Random();
    }

    @Transactional
    public List<RouteShortInfoDto> getAll(){
      return   routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .toList();

    }

    private RouteShortInfoDto mapToShortInfo(Route route) {
        RouteShortInfoDto dto =  modelMapper.map(route, RouteShortInfoDto.class);

    Optional<Picture> first = route.getPictures().stream().findFirst();
    dto.setImagUrl(first.get().getUrl());
        return dto;
    }


    @Transactional
    public RouteShortInfoDto getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;

        Optional<Route> route = routeRepository.findById(randomId);

        if (route.isEmpty()) {

        }

        return mapToShortInfo(route.get());
    }

    public boolean add(AddRouteDto data, MultipartFile gpxFile) {

        Route toInsert = modelMapper.map(data, Route.class);


        return  false;
    }
}
