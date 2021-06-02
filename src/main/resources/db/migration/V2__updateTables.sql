INSERT INTO Brand(brandName)
VALUES ('Ford'), ('DeLorean');

INSERT INTO Automobile(automobileName, brandId)
VALUES ('Coupe', 1), ('Focus', 1), ('DMC-1', 2);

INSERT INTO Part(dateOfProduction, serialNumber)
VALUES ('5.1.2015.',1000), ('15.6.2006',1001), ('28.3.2019',1002), ('10.8.2021',1003), ('22.4.2018',1004), ('3.12.2020',1005);

INSERT INTO automobilePart(automobileId, partId)
VALUES (1,1), (1,2), (2, 3), (2, 4), (3, 5), (3, 6);