--#1 Look at Park Locations
SELECT p_Park_Name, p_Latitude, p_Longitude
FROM Park_Locations;

--#2 See what plant are in each park
SELECT pl_Species, pl_Common_Name, pl_Plant_Type, p_Park_Name
FROM Plants, Park_Locations
WHERE pl_Park_Code = p_Park_Code;

--#3 See what animals are in each park
SELECT s_Scientific_Name, s_Common_Names, s_Occurence, p_Park_Name
FROM Species, Park_Locations
WHERE s_Park_name = p_Park_Name;

--#4 See the campsites of each park
SELECT c_name, c_Campsite_Type, c_Facility_Latitude, c_Facility_Logitude, c_Park_Name
FROM Campsites;

--#5 See the trails in each park
SELECT t_name, t_route_length, t_vistor_usage, t_avg_rating, t_features,t_activities, t_area_name
FROM Trails;

--#6 Check each parks average Temperatures Per Month
SELECT p_Park_Name, pt_Jan_Avg_High, pt_Jan_Avg_Low, pt_Feb_Avg_High, pt_Feb_Avg_Low, pt_Mar_Avg_High, pt_Mar_Avg_Low, pt_Apr_avg_high, 
       pt_Apr_avg_low, pt_May_avg_high, pt_May_avg_low, pt_Jun_Avg_High, pt_Jun_Avg_Low, pt_Jul_Avg_High, pt_Jul_Avg_Low,
       pt_Aug_Avg_High, pt_Aug_Avg_Low, pt_Sep_Avg_High, pt_Sep_Avg_Low, pt_Oct_Avg_High, pt_Oct_Avg_Low, pt_Nov_Avg_High,
       pt_Nov_Avg_Low, pt_Dec_Avg_High, pt_Dec_Avg_Low
FROM Park_Temps_Avg, Park_Locations
WHERE pt_Park_Name = p_Park_Name;

--#7 Check each parks average precipitation per month
SELECT p_Park_Name, pp_Jan_Precipitation, pp_Feb_Precipitation, pp_Mar_Precipitation, pp_Apr_Precipitation, pp_May_Precipitation,
       pp_Jun_Precipitation, pp_Jul_Precipitation, pp_Aug_Precipitation, pp_Sep_Precipitation, pp_Oct_Precipitation, pp_Nov_Precipitation,
       pp_Dec_Precipitation
FROM Park_Precipitation, Park_Locations
WHERE pp_Park_Name = p_Park_Name;

--#8 Find campsites in Yosemite that have noelectricity
SELECT c_Campsite_Type, c_Park_Name
FROM Campsites
WHERE c_Park_Name LIKE '%Yosemite%' and
c_Campsite_Type LIKE '%NONELECTRIC%';

--#9 Find Animal Species in Yosemite
SELECT s_Common_Names, p_Park_Name
FROM Species, Park_Locations
WHERE s_Park_name = p_Park_Name AND
s_Park_name LIKE '%Yosemite%';

--#10 Find Plant Species in Yosemite
SELECT pl_Species, p_Park_Name
FROM Plants, Park_Locations
WHERE pl_Park_Code = p_Park_Code AND
p_Park_Code = 'YOSE';

--#11 Find Trails and species of plants you might see on the trails in Yosemite
SELECT Distinct p_Park_Name, pl_Species, t_name, t_geoloc, t_route_length
FROM Park_Locations, Trails, Plants
WHERE p_Park_Name = t_area_name AND
p_Park_Code = pl_Park_Code AND
pl_Species IN (SELECT pl_Species
                     FROM Plants
                     WHERE pl_Park_Code = 'YOSE') AND
t_name IN (SELECT t_name
              FROM Trails
              WHERE t_area_name = 'Yosemite National Park')
Order BY t_name;

--#12 Fins Trails and species of animals you might see on the Trails in Yosemite
SELECT Distinct p_Park_Name, s_Common_Names, t_name, t_geoloc, t_route_length
FROM Park_Locations, Trails, Species
WHERE p_Park_Name = t_area_name AND
p_Park_Name = s_Park_name AND
s_Common_Names IN (SELECT s_Common_Names
                     FROM Species
                     WHERE s_Park_name = 'Yosemite National Park') AND
t_name IN (SELECT t_name
              FROM Trails
              WHERE t_area_name = 'Yosemite National Park')
ORDER BY s_Common_Names;

--#13 Show the species that are unique to Death Valley National Park
SELECT
   DISTINCT s_Common_Names
FROM
    species
WHERE
    s_Park_name LIKE 'Death Valley National Park' AND
    s_Scientific_Name NOT IN
        (SELECT
            s_Scientific_Name
        FROM
            species
        WHERE
            s_Park_name NOT LIKE 'Death Valley National Park')
ORDER BY
    s_Common_Names;

--#14 Show me the avg highs in Summer(June, July, Aug) in the parks where I can see
-- Sequoias!
SELECT
   DISTINCT s_Common_Names
FROM
    species
WHERE
    s_Park_name LIKE 'Death Valley National Park' AND
    s_Scientific_Name NOT IN
        (SELECT
            s_Scientific_Name
        FROM
            species
        WHERE
            s_Park_name NOT LIKE 'Death Valley National Park')
ORDER BY
    s_Common_Names;

--#15 What are the most common creature species, avg Precipitation in December, and acreage?

SELECT
    s_Common_Names, p_Park_Name, pp_Dec_Precipitation, p_Acres
FROM
    Species, Park_Locations, Park_Precipitation
WHERE
    s_Park_name = p_Park_Name AND
    p_Park_Name = pp_Park_Name AND
    s_Abundance LIKE 'Common'
GROUP BY
    s_Common_Names
ORDER BY
    p_Park_Name;

--#16 Update the Plants table where it = NULL to change it to N/A
UPDATE Plants
SET pl_Common_Name = 'N/A'
WHERE pl_Common_Name = '';

--#17 INSERT a new Trail into Trails
INSERT INTO Trails(t_trail_ID, t_name, t_area_name, t_city_name, t_state_name, t_country_name, 
                   t_geoloc, t_popularity, t_route_length, t_elevation_gain, t_difficulty_rating, 
                   t_route_type, t_vistor_usage, t_avg_rating, t_num_reviews, t_features, t_activities, t_units)
VALUES ('11111111', 'Construction Trail', 'Yosemite National Park', 'Yosemite Valley', 'California', 'United States',
        '{''lat'': 37.88888, ''lng'': -118.38888}', '11.1111', '11.111', '11111.776', '1', 'out and back', '0', '0', '0', 
        '[dogs-no, forest]', '[none]', 'i');

--#18 DELETE the previously added trail
DELETE FROM Trails
WHERE t_trail_ID = '11111111';

--#19 INSERT PLANTS
INSERT INTO Plants
VALUES(4055, 'DEVA', 'Smartius plantimus', 'Smart Plant', 1, 'Grasses', 
    '//fakesite.org', '//fakesite.org/Smartius-plantimus');

--#20 DELETE PLANTS
DELETE FROM Plants
WHERE pl_Species = 'Smartius plantimus';