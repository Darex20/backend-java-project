CREATE TABLE Brand
(
  brandId SERIAL NOT NULL,
  brandName VARCHAR NOT NULL,
  PRIMARY KEY (brandId)
);

CREATE TABLE Part
(
  partId SERIAL NOT NULL,
  serialNumber SERIAL UNIQUE,
  dateOfProduction DATE NOT NULL,
  PRIMARY KEY (partId)
);

CREATE TABLE Sale
(
  startDate DATE NOT NULL,
  endDate DATE NOT NULL,
  percentageOff FLOAT NOT NULL,
  saleId INT NOT NULL,
  PRIMARY KEY (saleId)
);

CREATE TABLE Automobile
(
  automobileId SERIAL NOT NULL,
  automobileName VARCHAR NOT NULL,
  brandId SERIAL NOT NULL,
  PRIMARY KEY (automobileId),
  FOREIGN KEY (brandId) REFERENCES Brand(brandId)
);

CREATE TABLE Article
(
  basePrice FLOAT NOT NULL,
  articleId INT NOT NULL,
  partId INT,
  saleId INT,
  PRIMARY KEY (articleId),
  FOREIGN KEY (partId) REFERENCES Part(partId),
  FOREIGN KEY (saleId) REFERENCES Sale(saleId)
);

CREATE TABLE automobilePart
(
  automobileId SERIAL NOT NULL,
  partId SERIAL NOT NULL,
  PRIMARY KEY (automobileId, partId),
  FOREIGN KEY (automobileId) REFERENCES Automobile(automobileId),
  FOREIGN KEY (partId) REFERENCES Part(partId)
);