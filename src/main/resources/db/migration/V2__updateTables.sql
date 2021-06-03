INSERT INTO Brand(brandName)
VALUES ('Ford'), ('DeLorean'), ('Studebaker');

INSERT INTO Automobile(automobileName, brandId)
VALUES ('Coupe', 1), ('Focus', 1), ('DMC-1', 2), ('Phaeton', 3);

INSERT INTO Part(dateOfProduction, serialNumber)
VALUES ('5.1.2015.',1000), ('15.6.2006',1001), ('28.3.2019',1002),
       ('10.8.2021',1003), ('22.4.2018',1004), ('3.12.2020',1005), ('10.5.2017',1006);

INSERT INTO automobilePart(automobileId, partId)
VALUES (1,1), (1,2),(1,3), (2, 4), (2, 5), (3, 6), (3, 7);

INSERT INTO sale(startDate, endDate, percentageOff, saleId)
VALUES ('22.4.2018', '15.6.2021', 10, 1), ('10.3.2017', '10.5.2019', 5, 2);

INSERT INTO article(basePrice, articleId, partId, saleId)
VALUES (100, 1, 1, 1), (200, 2, 2, 2), (300, 3, 3, 1)