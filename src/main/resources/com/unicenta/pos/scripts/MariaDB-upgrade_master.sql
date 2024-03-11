INSERT INTO taxcategories(id, name) VALUES ('015', 'IVA 15');
INSERT INTO taxcategories(id, name) VALUES ('013', 'IVA 13');

ALTER TABLE taxes ADD legalcode varchar(6) DEFAULT '0' NOT NULL;
ALTER TABLE taxes ADD datestart date;

INSERT INTO taxes(id, name, category, custcategory, parentid, rate, ratecascade, rateorder, legalcode) VALUES ('015', 'IVA 15', '015', NULL, NULL, 0.15, FALSE, NULL, '4');
INSERT INTO taxes(id, name, category, custcategory, parentid, rate, ratecascade, rateorder, legalcode) VALUES ('013', 'IVA 13', '013', NULL, NULL, 0.13, FALSE, NULL, '10');

UPDATE applications SET version = $APP_VERSION{} WHERE id = $APP_ID{};
COMMIT;