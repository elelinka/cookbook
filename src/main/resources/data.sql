INSERT INTO recipe_category(id, name, description, img) VALUES
(1, 'danie główne', 'Dania obiadowe', '/danie_glowne_0.jpg'),
(2, 'sałatki', 'Najlepsze sezonowe sałatki ze świeżych warzyw.', '/salatki_0.jpg'),
(3, 'makarony', 'Makarony w różnej postaci.', '/makarony.jpg'),
(4, 'desery', 'Ciasta bez pieczenia, czekolady, ciasteczka, gofry...', '/czekolada.jpg');

INSERT INTO recipe(id, name, description, like_counter, recipe_category_id) VALUES
(1, 'SAŁATKA Z MANGO I AWOKADO', 'Umytą i osuszoną rukolę ułożyć w salaterkach. Dodać obrane i pokrojone w kostkę mango, awokado oraz ser. Dodać połamane orzechy włoskie i wyłuskane ziarna granatu.', 25, 2),
(2, 'MAKARON Z GRZYBAMI', 'Grzyby oczyścić, umyć, osuszyć i pokroić w plasterki. Mrożone grzyby wyłożyć na sitko i kilka razy przelać ciepłą wodą w celu ich rozmrożenia, odcedzić i pokroić na plasterki.', 10, 3),
(3, 'GULASZ Z INDYKA Z KURKAMI', 'Filet pokroić w kostkę ok. 1,5 cm. Doprawić solą, pieprzem i obtoczyć w 1 łyżce mąki pszennej.', 2, 1),
(4, 'POLEWA CZEKOLADOWA', 'Śmietankę umieścić w rondelku i zagotować (z dodatkiem cukru jeśli go używamy).', 0, 4),
(5, 'CIASTO ZE ŚLIWKAMI I BUDYNIEM', 'Śliwki pokroić na ćwiartki, usunąć pestki. Mąkę wymieszać z proszkiem do pieczenia i cukrem. Dodać pokrojone na kawałeczki zimne masło lub margarynę i rozcierać palcami na drobną kruszonkę, lub miksować składnki mieszadłem miksera planetarnego, ewentualnie siekać składniki na stolnicy', 32, 4);

INSERT INTO ingredient(id, description, recipe_id) VALUES
(1, '500 g śliwek np. węgierek', 5),
(2, '300 g mąki pszennej', 5),
(3, '1 łyżeczka proszku do pieczenia', 5),
(4, '120 g cukru', 5),
(5, '2 garście rukoli', 1),
(6, '1 mango', 1),
(7, '1 awokado', 1),
(8, 'ok. 450 g filetu z indyka (użyłam polędwiczki)', 3),
(9, '200 g kurek', 3),
(10, '200 g borowików (świeżych lub mrożonych)', 2),
(11, '150 g makaronu wstążki', 2),
(12, '1 łyżka masła + 1/2 łyżki oliwy', 2),
(13, '250 ml śmietanki 30%', 4),
(14, '150 g czekolady deserowej (lekko gorzkiej) lub gorzkiej', 4);

INSERT INTO recipe_image(id, path, recipe_id) VALUES
(1, '/salatka_z_mango_awokado_01.jpg', 1),
(2, '/makaron_z_grzybami_01_0.jpg', 2),
(3, '/gulasz_z_indyka_z_kurkami_01.jpg', 3),
(4, '/polewa_czekoladowa_01.jpg', 4),
(5, '/ciasto_ze_sliwkami_budyniem_01.jpg', 5),
(6, '/ciasto_ze_sliwkami_budyniem_02.jpg', 5);
