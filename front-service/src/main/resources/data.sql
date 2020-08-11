insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status,points) values (1,1, 'admin@gmail.com','Admin','','$2a$10$pz4xJn5hEFaxKCpJYdCIFeJgwtaqiJ24Th8bk0Lm2w2y.Db5Cslom','admin',1,0);
insert into authority (id,authority, user_name) values (1,'ROLE_ADMIN','admin');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status,points) values (2,1, 'seller@gmail.com','Seller','','$2a$10$SCWgUYqcvf5s4w4cNZmFI.5RQ/Iby2ItE2pEXk9lsaD2KBO/ZWeFO','seller',1,0);
insert into authority (id,authority, user_name) values (2,'ROLE_SELLER','seller');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status,points) values (3,0, 'seller2@gmail.com','Seller2','','$2a$10$SCWgUYqcvf5s4w4cNZmFI.5RQ/Iby2ItE2pEXk9lsaD2KBO/ZWeFO','seller2',1,0);
insert into authority (id,authority, user_name) values (3,'ROLE_SELLER','seller2');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status,points) values (4,1, 'buyer@gmail.com','Buyer','','$2a$10$cwBCBwwMCzhOYqJp5Eioo./KN0jJYkQVOL/2ndZwNKzSqE6jgbDzO','buyer',1,0);
insert into authority (id,authority, user_name) values (4,'ROLE_BUYER','buyer');

insert into user (id,admin_verification, email, first_name, last_name, password, user_name, user_status,points) values (5,1, 'buyer2@gmail.com','Buyer2','','$2a$10$cwBCBwwMCzhOYqJp5Eioo./KN0jJYkQVOL/2ndZwNKzSqE6jgbDzO','buyer2',1,0);
insert into authority (id,authority, user_name) values (5,'ROLE_BUYER','buyer2');


insert into category(id,name,description) values (1,'Electronics','Laptops,Hard drives,Tvs,mobile phones..');
insert into category(id,name,description) values (2,'Jewellery','Necklace,bracelets,ear-rings...');
insert into category(id,name,description) values (3,'Mobile Phones','iPhone,Samsung,Nokia,redMI...');
insert into category(id,name,description) values (4,'Home Decoration','Crockery sets,jars,containers,cookware....');
insert into category(id,name,description) values (5,'Baby care','Soaps,oil,body lotion,diapers....');

insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (8,'TANTU Men Boots',250.8,10,1,'<h3>Description:</h3>\n TANTU Men Boots Anti-Skidding Leather Shoes Men Popular Comfy Spring Autumn Shoes Snow Boots Durable Outsole.','boot.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (7,'Beach Air Mattress',20.6,10,1,'<h3>Pros:</h3>\n Outdoor Water Rowing Boat Sleeping Bed Swimming Floating Row Lounger Inflatable Beach Air Mattress Rowing Boat 230*115CM','boat.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (6,'Mares Avanti Quattro Plus',25.4,10,1,'<h3>Pros:</h3>\n Great performance in almost all conditions\nCan produce very powerful frog kicks\n Very comfortable to dive with\n Available as either closed heel or open heel','swimfins.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (5,'Bose Frames Alto',150.8,10,1,'<h3>Features:</h3>\n Receive a free pair of Bose non-polarized OR polarized Lenses with every order of Bose Frames.','glasses.png',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (4,'Leather Jacket',50.77,10,1,'<h3>Jacket Features:</h3>','leather_jacket.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (3,'Iphone Pro11',1110.38,10,1,'<h3>Features:</h3>\nReleased 2019, September 20. 188g, 8.1mm thickness. iOS 13, up to iOS 13.5. 64GB/256GB/512GB storage, no card slot.\n17% 3,339,305 hits.\n 209 Become a fan.\n 5.8\n 1125x2436 pixels.\n 12MP. 2160p.\n 4GB RAM. Apple A13 Bionic.\n 046mAh.','iphone11.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (2,'Wireless Earphone',23.8,10,1,'<h3>Features:</h3>LEMFO M1 Smart Bracelet BT Earphone 0.96-Inch TFT Screen Smart Watch Heart Rate Blood Pressure Monitoring Calorie Fitness Alarm Sports Wristwatch for Android / iOS Valentines Day Gifts for Her/Him','watch.jpg',2,false);
insert into product (id,name,price, tax, cat_id, description, product_image, added_by,sold_status) values (1,'Macbook Pro 16',2500.8,10,1,'<h3>Features:</h3>\nPrice. $1299. ...\n Finish. Silver Space Gray.\n Display. Retina display. ...\n Processor. 1.4GHz quad‑core 8th‑generation Intel Core i5, Turbo Boost up to 3.9GHz, with 128MB of eDRAM. ...\n Storage1 256GB. ...\n Memory. 8GB. ...\n Graphics. Intel Iris Plus Graphics 645.Charging and Expansion','macbook-pro.jpg',2,false);

-- CMS
# insert into content(slug,cont,name) values('privacy-policy','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod','Privacy Policy');
# insert into content(slug,cont,name) values('terms-and-conditions','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod','Terms and Condition');
# insert into content(slug,cont,name) values('about-us','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod','About');
# insert into content(slug,cont,name) values('faq','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod','FAQ');