CREATE TABLE Species (
   s_Species_ID varchar (10) not null,
   s_Park_name char (45) not null,
   s_Category char (25) not null,
   s_Order char (25),
   s_Family char (25),
   s_Scientific_Name varchar (55) not null,
   s_Common_Names varchar (170) not null,
   s_Record_Status char (18) not null,
   s_Occurence varchar (40),
   s_Nativeness char (10),
   s_Abundance char (8),
   s_Seasonality varchar (25),
   s_Conservation_Status char (25)
);

CREATE TABLE Trails (
   t_trail_ID decimal (8,0) not null,
   t_name varchar (100) not null,
   t_area_name char (45) not null,
   t_city_name char (45) not null,
   t_state_name char (15) not null,
   t_country_name char (15) not null,
   t_geoloc varchar (50) not null,
   t_popularity decimal (6,4) not null,
   t_route_length decimal (9,3) not null,
   t_elevation_gain decimal (7,3) not null,
   t_difficulty_rating decimal (1,0) not null,
   t_route_type char (20) not null,
   t_vistor_usage decimal (1,0),
   t_avg_rating decimal (2,1) not null,
   t_num_reviews decimal (4,0) not null,
   t_features varchar (145) not null,
   t_activities varchar (165) not null,
   t_units char (1) not null
);

CREATE TABLE Park_Locations (
   p_Park_Code char (5) not null,
   p_Park_Name char (45) not null,
   p_State varchar (10) not null,
   p_Acres decimal (7) not null,
   p_Latitude decimal (4,2) not null,
   p_Longitude decimal (5,2) not null
);

CREATE TABLE Park_Precipitation (
   pp_Park_Name char (45) not null,
   pp_Jan_Precipitation decimal (3,2) not null,
   pp_Feb_Precipitation decimal (3,2) not null,
   pp_Mar_Precipitation decimal (3,2) not null,
   pp_Apr_Precipitation decimal (3,2) not null,
   pp_May_Precipitation decimal (3,2) not null,
   pp_Jun_Precipitation decimal (3,2) not null,
   pp_Jul_Precipitation decimal (3,2) not null,
   pp_Aug_Precipitation decimal (3,2) not null,
   pp_Sep_Precipitation decimal (3,2) not null,
   pp_Oct_Precipitation decimal (3,2) not null,
   pp_Nov_Precipitation decimal (3,2) not null,
   pp_Dec_Precipitation decimal (4,2) not null
);

CREATE TABLE Campsites (
   c_Campsite_ID decimal(5,0) not null,
   c_name varchar(50) not null,
   c_Campsite_Type char (40) not null,
   c_Facility_ID decimal (6,0) not null,
   c_Facility_Latitude decimal (10,8),
   c_Facility_Logitude decimal (10,8),
   c_Facility_name varchar (60) not null,
   c_Adress_State char (2) not null,
   c_Org_Abbrev_Name char (5) not null,
   c_Park_Name char (39) not null
);

CREATE TABLE Plants (
   pl_Plant_ID decimal (4,0) not null,
   pl_Park_Code char (10) not null,
   pl_Species varchar (55) not null,
   pl_Common_Name char (45),
   pl_Ranking decimal (4,0) not null,
   pl_Plant_Type varchar (40) not null,
   pl_Plant_URL varchar (75) not null,
   pl_QR_Codes varchar (85) not null
);

CREATE TABLE Park_Temps_Avg (
   pt_Park_Name char (45) not null,
   pt_Jan_Avg_Low decimal(2,0) not null,
   pt_Jan_Avg_High decimal(2,0) not null,
   pt_Feb_Avg_Low decimal (2,0) not null,
   pt_Feb_Avg_High decimal (2,0) not null,
   pt_Mar_Avg_Low decimal (2,0) not null,
   pt_Mar_Avg_High decimal (2,0) not null,
   pt_Apr_avg_low decimal (2,0) not null,
   pt_Apr_avg_high decimal (2,0) not null,
   pt_May_avg_low decimal (2,0) not null,
   pt_May_avg_high decimal (3,0) not null,
   pt_Jun_Avg_Low decimal (2,0) not null,
   pt_Jun_Avg_High decimal (3,0) not null,
   pt_Jul_Avg_Low decimal (2,0) not null,
   pt_Jul_Avg_High decimal (3,0) not null,
   pt_Aug_Avg_Low decimal (2,0) not null,
   pt_Aug_Avg_High decimal (3,0) not null,
   pt_Sep_Avg_Low decimal (2,0) not null,
   pt_Sep_Avg_High decimal (3,0) not null,
   pt_Oct_Avg_Low decimal (2,0) not null,
   pt_Oct_Avg_High decimal (2,0) not null,
   pt_Nov_Avg_Low decimal (2,0) not null,
   pt_Nov_Avg_High decimal (2,0) not null,
   pt_Dec_Avg_Low decimal (2,0) not null,
   pt_Dec_Avg_High decimal (2,0) not null
);