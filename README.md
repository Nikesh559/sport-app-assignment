I have created spring boot application for this asssignment.
------------------------------------------------------------------------------------------------------------------------
- Problem 1
Endpoint /tour/matches returns all the matches for a given tour name.
The endpoint latency increases linearly with the number of tours. Modify the endpoint to increase the performance.<br>
<b>Solution</b>:

1. Created Index on column tourId in 'matches' table for optimize lookup.
2. Implemented API caching to cache tourName response from database.

--------------------------------------------------------------------------------------------------------------
- Problem 2
Modify the endpoint /sport/tour/match to also return match's id, startTime and format <br>
<b>Solution</b>:

    Implemented endpoint "/sport/{id}/tour/match" that also return match's id, startTime and format

--------------------------------------------------------------------------------------------------------------
- Problem 3
  Requirement: News Support for Matches and Tours
  Functional Requirements:
  1. News can be created for a match or a tour.
  2. Each news created for a match also belongs to the corresponding tour.
  3. Each news created for a tour also belongs to the corresponding sport.
  Technical Requirements:
  1. Create an endpoint to create news.
  2. Create an endpoint to fetch news by match id
  3. Create an endpoint to fetch news by tour id
  4. Create an endpoint to fetch news by sport id

  <b>Solution</b>:

  Created new table News with below columns
  * id - to store news id (Primary Key)
  * title - title of news
  * description - to store news description
  * type - it stores for which entity(MATCH/TOUR) this news is created. Can also create for any other type.
  * typeId - it stores the id of entity(MATCH/TOUR) 

  id 	| title	| description | type | typeId
  ----| ----- | ------| ------ | --------
  1 | IND vs AUS | Aussies | MATCH | 101
  2 | AUS vs NZ Tour | Great Match | TOUR | 102
  3 | IPL | IPL Matches | TOUR | 103
  4 | MI vs RCB | RCB Won | MATCH | 104
  5 | WI vs IND | India Won | MATCH | 105

  Technical Requirements Solutions:
  1. Create an endpoint to create news.
     * To create news for MATCH or TOUR, set type(MATCH/TOUR) accordingly. System can incorporate news different type as well.

  2. Create an endpoint to fetch news by match id
     * Created endpoint "/match/{matchId}/news". Fetches news by type as "MATCH" in news table.

  3. Create an endpoint to fetch news by tour id
     * Created endpoint "/tour/{tourId}/news". Fetches news by type as "TOUR" in news table & its corresponding match news.

  4. Create an endpoint to fetch news by sport id
     * Created endpoint "/sport/{sportId}/news". Fetch news by tourIds for sport.
