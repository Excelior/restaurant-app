package com.mycompany.app;

import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.*;

class Parser {

    private GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAK5h7ZXISX82qEcOc2Jd5EER8RSEVUx-M");
    private PlaceType restaurantType = PlaceType.RESTAURANT;

    PlacesSearchResult[] getPlacesSearchResults(LatLng latLng)
    {
        PlacesSearchResult[] resultats = new PlacesSearchResult[0];

        NearbySearchRequest request = new NearbySearchRequest(context);
        request.type(restaurantType);
        request.location(latLng);
        request.radius(1000);

        try {
            PlacesSearchResponse response = request.await();
            resultats = response.results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultats;
    }

    PlaceDetails getPlaceDetailsById(String id)
    {
        PlaceDetails resultat = new PlaceDetails();

        PlaceDetailsRequest request = PlacesApi.placeDetails(context, id);

        try {
            PlaceDetails response = request.await();
            resultat = response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultat;
    }
}
