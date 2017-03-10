package com.mycompany.app;

import com.google.maps.model.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @RequestMapping("/restaurant")
    public PlacesSearchResult[] GetRestaurants(@RequestParam(value = "lat", defaultValue = "0") Double lat,
                                               @RequestParam(value = "lng", defaultValue = "0") Double lng, Model model)
    {
        Parser placesParser = new Parser();
        LatLng latLng = new LatLng(lat,lng);

        PlacesSearchResult[] restaurants = placesParser.getPlacesSearchResults(latLng);

        model.addAttribute("lat", lat);
        return restaurants;
    }

    @RequestMapping("/restaurant/{id}")
    public PlaceDetails GetRestaurantById(@PathVariable(value="id") String id)
    {
        Parser placesParser = new Parser();
        PlaceDetails restaurant = placesParser.getPlaceDetailsById(id);

        return restaurant;
    }

}
