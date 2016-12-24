insert into role (id, role) values (1, "ADMIN");
insert into role (id, role) values (2, "USER");


insert into user (id, email, userName, password, firstName, lastName, active, address, phoneNumber, role_id) values (1, "admin@mail.ru", "admin", "12345678", "Ruslan", "Matso", true, "lviv", "+380993414113", 1);
insert into user (id, email, userName, password, firstName, lastName, active, address, phoneNumber, role_id) values (2, "bodya@gmail.com", "user1", "11111111", "Bohdan", "Konon", true, "kyiv", "+380957418663", 2);
insert into user (id, email, userName, password, firstName, lastName, active, address, phoneNumber, role_id) values (3, "igoryok@mail.ru", "user2", "11112222", "Igor", "Levko", false, "odesa", "+380503687412", 2);
insert into user (id, email, userName, password, firstName, lastName, active, address, phoneNumber, role_id) values (4, "romka@gmail.com", "user3", "11113333", "Roma", "Parubiy", true, "ternopil", "+380637842369", 2);


insert into cart (id, shippingAddress, user_id) values (1, "Lviv", 2);
insert into cart (id, shippingAddress, user_id) values (2, "Kyiv", 3);
insert into cart (id, shippingAddress, user_id) values (3, "Uzhghorod", 4);


insert into category (id, title, parent_id, hasChildren) values (1, "Cell Phones", null, false);
insert into category (id, title, parent_id, hasChildren) values (2, "Shoes", null, false);
insert into category (id, title, parent_id, hasChildren) values (3, "Books", null, false);
insert into category (id, title, parent_id, hasChildren) values (4, "Computers", null, true);
insert into category (id, title, parent_id, hasChildren) values (5, "Laptops", 4, false);
insert into category (id, title, parent_id, hasChildren) values (6, "PC", 4, false);

insert into image (id, name, image) values (1, "Apple iPhone.png", null);
insert into image (id, name, image) values (2, "POSH MOBILE KICK.png", null);
insert into image (id, name, image) values (3, "BLU Advance 5.0.png", null);
insert into image (id, name, image) values (4, "", null);
insert into image (id, name, image) values (5, null, null);
insert into image (id, name, image) values (6, "Samsung Galaxy S7 Edge.png", null);
insert into image (id, name, image) values (7, "Samsung Galaxy J7 SM-J700H DS GSM.png", null);
insert into image (id, name, image) values (8, "Honor 5X.png", null);
insert into image (id, name, image) values (9, "Blu Dash JR D141W Dual Sim.png", null);
insert into image (id, name, image) values (10, "RCA 6-inch 4G LTE.png", null);
insert into image (id, name, image) values (11, "BLU Vivo XL Smartphone.png", null);
insert into image (id, name, image) values (12, "ASUS ZenFone 3 Laser.png", null);
insert into image (id, name, image) values (13, "ZTE Axon 7.png", null);
insert into image (id, name, image) values (14, "RCA M1 4.0.png", null);
insert into image (id, name, image) values (15, "Apple iPhone 5 16GB.png", null);
insert into image (id, name, image) values (16, "Kenneth Cole New York Men Mix-Er Oxford.png", null);
insert into image (id, name, image) values (17, "Steve Madden Men Esos Oxford.png", null);
insert into image (id, name, image) values (18, "Bruno Magli Men Ragusa Penny Loafer.png", null);
insert into image (id, name, image) values (19, "Magnanni Men Hamilton.png", null);
insert into image (id, name, image) values (20, "Calvin Klein Men Nino Patent Tuxedo.png", null);
insert into image (id, name, image) values (21, "Truly Madly Guilty.png", null);
insert into image (id, name, image) values (22, "End of Watch A Novel (The Bill Hodges Trilogy).png", null);
insert into image (id, name, image) values (23, "The Underground Railroad.png", null);
insert into image (id, name, image) values (24, "Go Set a Watchman A Novel.png", null);
insert into image (id, name, image) values (25, "The Girl on the Train.png", null);
insert into image (id, name, image) values (26, "HP Stream Laptop PC 14-ax020nr.png", null);
insert into image (id, name, image) values (27, "Acer Switch Alpha 12 2-n-1.png", null);
insert into image (id, name, image) values (28, "Lenovo Ideapad 310 15.6 inch Laptop.png", null);
insert into image (id, name, image) values (29, "ASUS Chromebook C300SA Compact 13.3 inch.png", null);
insert into image (id, name, image) values (30, "Acer Switch Alpha 12 SA5-271-39N9 12-inch QHD Touchscreen.png", null);


insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (1, "Apple iPhone 6", "one of the best phones in the world", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum", 415.00, 6, true, 1, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (2, "POSH MOBILE KICK", "This brand new 5.0 inch 4G SMARTPHONE has 2 SIM Card slots that work on every GSM carrier", "This item is very cool", 69.99, 350, false, 2, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (3, "BLU Advance 5.0", "Unlocked Dual SIM smartphone, with Android 5.1 Lollipop", "Wow!!!!", 59.99, 700, false, 3, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (4, "Moto G (4th Generation)", "Fast 4G LTE speed, an up to 1.5 GHz octa-core processor, 2 GB of RAM, and a bright 5.5 inch full HD (1080p) display ensures videos and games run smoothly and look great", "Full sescription of this item. This item is very good!", 199.99, 0, true, 4, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (5, "Samsung Galaxy J5 SM-J500H/DS GSM", "5.0 inch Super AMOLED Capacitive Multi-Touchscreen w/ Protective Corning Gorilla Glass", "Full sescription of this item. This item is very good!", 169.98, 380, true, 5, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (6, "Samsung Galaxy S7 Edge", "Fast battery charging: 60% in 30 min (Quick Charge 2.0); Wireless charging (Qi/PMA) ; market dependent; ANT+ support; S; Voice natural language commands and dictation", "Full sescription of this item. This item is very good!", 594.80, 75, true, 6, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (7, "Samsung Galaxy J7 SM-J700H/DS GSM", "5.5 inch Super AMOLED Capacitive Multi-Touchscreen w/ Protective Corning Gorilla Glass", "Full sescription of this item. This item is very good!", 209.00, 68, true, 7, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (8, "Honor 5X", "Unlocked Dual SIM LTE smartphone with three card slots. Supports nano-sim, micro-SIM, and a microSD card up to 128GB. Works with AT&T and T-Mobile Networks.", "Full sescription of this item. This item is very good!", 169.99, 250, true, 8, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (9, "Blu Dash JR D141W Dual Sim", "3.5 inch TFT Display Capacitive Multi-Touchscreen Android v2.3 (Gingerbread), 1.0 GHz Processor, 2 Megapixel Camera", "Full sescription of this item. This item is very good!", 28.99, 150, true, 9, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (10, "RCA 6-inch 4G LTE", "6-inch Unlocked 4G LTE, Quad core, Quad band, Dual SIM, Android world smartphone", "Full sescription of this item. This item is very good!", 129.99, 75, true, 10, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (11, "BLU Vivo XL Smartphone", "Aesthetically engineered for a flawless liquid metal finish, vivid 5.5 inch display HD Super AMOLED Color", "Full sescription of this item. This item is very good!", 149.99, 400, true, 11, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (12, "ASUS ZenFone 3 Laser", "5.5-inch unlocked Dual SIM cell phone with IPS FHD display, 1080 X 1920 resolution", "Full sescription of this item. This item is very good!", 179.00, 100, true, 12, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (13, "ZTE Axon 7", "Great sounding and listening smartphone with hifi audio - High quality sound reproduction and amplification of music/video playback and record.", "Full sescription of this item. This item is very good!", 349.98, 369, true, 13, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (14, "RCA M1 4.0", "Unlocked dual SIM phone, Android 4.4 (KitKat), 4.0 inch High Resolution WVGA Display, Dual core 1.3 GHz Processor", "Full sescription of this item. This item is very good!", 57.99, 280, true, 14, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (15, "Apple iPhone 5 16GB", "one of the best phones in the world", "Full sescription of this item. This item is very good!", 300.00, 200, true, 15, 1);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (16, "Kenneth Cole New York Men Mix-Er Oxford", "Leater synthetic sole shoes", "Full sescription of this item. This item is very good!", 195.00, 40, true, 16, 2);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (17, "Steve Madden Men Esos Oxford", "Smooth and perforated detailed upper", "Full sescription of this item. This item is very good!", 115.00, 75, true, 17, 2);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (18, "Bruno Magli Men Ragusa Penny Loafer", "Leater, suede shoes", "Full sescription of this item. This item is very good!", 425.00, 150, true, 18, 2);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (19, "Magnanni Men Hamilton", "Double buckle cap toe, leather", "Full sescription of this item. This item is very good!", 395.00, 100, true, 19, 2);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (20, "Calvin Klein Men Nino Patent Tuxedo", "Fashion dress oxford, leather", "Full sescription of this item. This item is very good!", 150.00, 150, true, 20, 2);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (21, "Truly Madly Guilty", "The new novel from Liane Moriarty, the #1 New York Times bestselling author", "Full sescription of this item. This item is very good!", 12.74, 200, true, 21, 3);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (22, "End of Watch: A Novel (The Bill Hodges Trilogy)", "The spectacular finale to the New York Times bestselling trilogy that began with Mr. Mercedes and Finders Keepers", "Full sescription of this item. This item is very good!", 10.55, 320, true, 22, 3);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (23, "The Underground Railroad", "a magnificent tour de force chronicling a young slave's adventures as she makes a desperate bid for freedom in the antebellum South", "Full sescription of this item. This item is very good!", 8.44, 300, true, 23, 3);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (24, "Go Set a Watchman: A Novel", "From Harper Lee comes a landmark new novel set two decades after her beloved Pulitzer Prize–winning masterpiece, To Kill a Mockingbird.", "Full sescription of this item. This item is very good!", 9.90, 385, true, 24, 3);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (25, "The Girl on the Train", "The debut psychological thriller that will forever change the way you look at other people's lives.", "Full sescription of this item. This item is very good!", 9.12, 400, true, 25, 3);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (26, "HP Stream Laptop PC 14-ax020nr", "Intel Celeron N3060, 1.6GHz, dual-core Processor", "Full sescription of this item. This item is very good!", 219.99, 100, true, 26, 5);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (27, "Acer Switch Alpha 12 2-n-1", "6th Generation Intel Core i5-6200U Processor 2.3GHz", "Full sescription of this item. This item is very good!", 749.99, 220, true, 27, 5);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (28, "Lenovo Ideapad 310 15.6 inch Laptop", "AMD A12-9700P processor, 2.5GHz with windows 10", "Full sescription of this item. This item is very good!", 479.00, 320, true, 28, 5);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (29, "ASUS Chromebook C300SA Compact 13.3 inch", "Intel Core Celeron N3060 1.6 GHz (Turbo to 2.48 GHz)", "Full sescription of this item. This item is very good!", 199.00, 150, true, 29, 5);
insert into product (id, title, description, fullDescription, price, amount, active, image_id, category_id) values (30, "Acer Switch Alpha 12 SA5-271-39N9 12-inch QHD Touchscreen", "6th Generation Intel Core i3-6100U Processor 2.3GHz", "Full sescription of this item. This item is very good!", 487.98, 240, true, 30, 5);


insert into cartproduct (id, productbought, product_id) values (1, false, 1);
insert into cartproduct (id, productbought, product_id) values (2, false, 3);
insert into cartproduct (id, productbought, product_id) values (3, false, 6);
insert into cartproduct (id, productbought, product_id) values (4, false, 2);
insert into cartproduct (id, productbought, product_id) values (5, false, 5);
insert into cartproduct (id, productbought, product_id) values (6, false, 7);
insert into cartproduct (id, productbought, product_id) values (7, false, 12);
insert into cartproduct (id, productbought, product_id) values (8, false, 1);
insert into cartproduct (id, productbought, product_id) values (9, false, 2);
insert into cartproduct (id, productbought, product_id) values (10, false, 6);
insert into cartproduct (id, productbought, product_id) values (11, false, 28);
insert into cartproduct (id, productbought, product_id) values (12, false, 3);


insert into cart_cartproduct (cart_id, cartproducts_id) values (1, 1);
insert into cart_cartproduct (cart_id, cartproducts_id) values (1, 2);
insert into cart_cartproduct (cart_id, cartproducts_id) values (1, 3);
insert into cart_cartproduct (cart_id, cartproducts_id) values (1, 4);
insert into cart_cartproduct (cart_id, cartproducts_id) values (2, 5);
insert into cart_cartproduct (cart_id, cartproducts_id) values (2, 6);
insert into cart_cartproduct (cart_id, cartproducts_id) values (2, 7);
insert into cart_cartproduct (cart_id, cartproducts_id) values (2, 8);
insert into cart_cartproduct (cart_id, cartproducts_id) values (3, 9);
insert into cart_cartproduct (cart_id, cartproducts_id) values (3, 10);
insert into cart_cartproduct (cart_id, cartproducts_id) values (3, 11);
insert into cart_cartproduct (cart_id, cartproducts_id) values (3, 12);
