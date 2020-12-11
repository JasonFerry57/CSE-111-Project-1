SELECT pt_Park_Name, MAX(pt_Jan_Avg_High, pt_Feb_Avg_High, pt_Mar_Avg_High, 
pt_Apr_avg_high, pt_May_avg_high, pt_Jun_Avg_High, pt_Jul_Avg_High, 
pt_Aug_Avg_High, pt_Sep_Avg_High, pt_Oct_Avg_High, pt_Nov_Avg_High, pt_Dec_Avg_High)
FROM Park_Temps_Avg;

SELECT pt_Dec_Avg_High, pt_Dec_Avg_Low
FROM Park_Temps_Avg;

SELECT COUNT(pl_Species)
FROM Plants, Park_Locations
WHERE p_Park_Code = pl_Park_Code AND
p_Park_Name LIKE 'Channel Islands National Park';

SELECT pl_Species
FROM Plants, Park_Locations
WHERE p_Park_Code = pl_Park_Code AND
p_Park_Name LIKE 'Channel Islands National Park';

SELECT pl_Common_Name
FROM Plants, Park_Locations
WHERE p_Park_Code = pl_Park_Code AND
p_Park_Name LIKE 'Channel Islands National Park'
GROUP BY pl_Common_Name;