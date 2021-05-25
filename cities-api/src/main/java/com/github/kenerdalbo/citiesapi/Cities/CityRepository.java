package com.github.kenerdalbo.citiesapi.Cities;

import com.github.kenerdalbo.citiesapi.states.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {


    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> (SELECT lat_lon FROM cidade WHERE id=?2)) as distance", nativeQuery = true)
    Double distanceByPoints(final Long cityId1, final Long cityId2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

    @Query(value = "SELECT * FROM cidade WHERE UPPER(nome) like %:name%", nativeQuery = true)
    List<City> byName(@Param("name")String name);

    @Query(value= "select *\n" +
            " from cidade  where id<>:cid and (6371 *\n" +
            "        acos(\n" +
            "            cos(radians((select latitude from cidade where id=:cid))) *\n" +
            "            cos(radians(latitude)) *\n" +
            "            cos(radians((select longitude from cidade where id=:cid)) - radians(longitude)) +\n" +
            "            sin(radians((select latitude from cidade where id=:cid))) *\n" +
            "            sin(radians(latitude))\n" +
            "        )) <:dist", nativeQuery = true)
    List<City> encontrarCidadesProximasKm(@Param("cid") Long city,
                                          @Param("dist")int distanciaKm);
}