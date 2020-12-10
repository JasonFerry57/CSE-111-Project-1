DELETE FROM Campsites;
DELETE FROM Plants;
DELETE FROM Park_Temps_Avg;
DELETE FROM Park_Locations;
DELETE FROM Park_Precipitation;
DELETE FROM Species;
DELETE FROM Trails;


-- .mode "csv"
-- .separator ","
-- .import '| tail -n +2 /home/jrenteria5/Desktop/DBProject/data/CAfed_campsitesEDITED.csv' Campsites
-- .import '| tail -n +2 /home/jrenteria5/Desktop/DBProject/data/CANationalParkPlants.csv.csv' Plants
-- .import '| tail -n +2 /home/jrenteria5/Desktop/DBProject/data/CAParkAvgTemps.csv' Park_Temps_Avg
-- .import '| tail -n +2 /home/jrenteria5/Desktop/DBProject/data/CAParkLocations.csv' Park_Locations
-- .import '| tail -n +2 /home/jrenteria5/Desktop/DBProject/data/CAParkPrecipitation.csv' Park_Precipitation
-- .import '| tail -n +2 /home/jrenteria5/Desktop/DBProject/data/CAspecies.csv' Species
-- .import '| tail -n +2 /home/jrenteria5/Desktop/DBProject/data/CATrails data - nationalpark.csv' Trails