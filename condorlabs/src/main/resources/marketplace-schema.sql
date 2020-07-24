drop table if exists marketplace.shopping;
drop table if exists marketplace.product;
drop table if exists marketplace.category;

create table marketplace.category(
    id      int primary key auto_increment,
    name    varchar(200) not  null
);

insert into marketplace.category
(id,name) values
(1,'HOME'),
(2,'GAMES'),
(3,'SHOES');

create table marketplace.product(
    id                      int primary key auto_increment,
    name                    varchar(100) not  null,
    description             varchar(3000),
    price                   int not null,
    image_url               varchar(500) not null,
    stock          int not null,
    category_id     int not null
);

alter table marketplace.product
add foreign key (category_id) references category(id);

insert into marketplace.product
(id, name, description, price, image_url, stock, category_id) values
(1,'DualShock 4 Wireless Controller','DualShock 4 Wireless Controller for PlayStation 4 - Jet Black'
    , 65,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS6WkZBoKXNSyCzq0VOzVr53OvGG3N9TOEeaw&usqp=CAU'
	, 8, 2),
(2,'Final Fantasy VII: Remake', 'Final Fantasy VII: Remake - PlayStation 4'
    , 50,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTbWi4KSGWtrTTOcg0_ROy0CmRhgzh3rpLPITfEaZ8BdeJyBrAovtHftGHFtSs&usqp=CAc'
	, 10, 2),
(3,'Chefman TurboFry 3.6 Quart Air Fryer'
	,'Chefman TurboFry 3.6 Quart Air Fryer Oven w/Dishwasher Safe Basket and Dual Control Temperature, 60 Minute Timer & 15 Cup Capacity, BPA-Free, Matte Black, Healthy Frying Cookbook Included'
    , 60,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3VrTNLIGrlmn5l_MyLrm1tdTFvjL9-NhaCXk5RathL-NvoWrvgTrt-LAyiew5mRAoZ200soo&usqp=CAc'
	, 12, 1),
(4,'Air Jordan 1', 'Air Jordan 1 Mid Mens Fashion Basketball Shoes 554724-067'
    , 194,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRH83PIsV7LQI-AgHQvdw147EQi5w1so0VXmw&usqp=CAU'
	, 5, 3),
(5,'AmazonBasics Microwave', 'AmazonBasics Microwave, Small, 0.7 Cu. Ft, 700W, Works with Alexa'
    , 60,'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT5C3J-prF9r3Gf2wAxIMdJZkB5Hnmy3FMtWA&usqp=CAU'
	, 14, 1);

create table marketplace.shopping(
    id    int primary key auto_increment,
    product_id       	int not null,
    date_shopping       varchar(20),
    status              varchar(20)
);

alter table marketplace.shopping
add foreign key (product_id) references product(id);
