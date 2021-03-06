create table event (id bigint not null auto_increment, description varchar(255), image longblob, name varchar(255) not null, user_id bigint not null, primary key (id))
create table parent (avatar longblob, birth_date datetime not null, cellphone varchar(255) not null, country varchar(255) not null, money integer not null, municipality varchar(255) not null, name varchar(255) not null, participation_certificate longblob, phone varchar(255) not null, region varchar(255) not null, surname varchar(255) not null, id bigint not null, primary key (id))
create table provider (address varchar(255) not null, address_number varchar(255) not null, avatar longblob, brand_name varchar(255) not null, country varchar(255) not null, distinctive_title varchar(255) not null, identification_document longblob, legal_represantation varchar(255) not null, legal_represantation_email varchar(255) not null, legal_represantation_phone varchar(255) not null, municipality varchar(255) not null, participation_certificate longblob, postal_code varchar(255) not null, public_finance_agency varchar(255) not null, region varchar(255) not null, sector_type varchar(255) not null, tax_identification_number varchar(255) not null, id bigint not null, primary key (id))
create table role (role varchar(255) not null, id bigint not null, primary key (id))
create table user (id bigint not null auto_increment, email varchar(255) not null, password varchar(255) not null, username varchar(255) not null, primary key (id))
alter table event add constraint UK_mt8ulcc4k7fnc56rxaeu1sa33 unique (name)
alter table parent add constraint UK_3m21is5lsuwue4plcfo3vf817 unique (avatar)
alter table parent add constraint UK_1t2ks8tkfecqx7ravc0dattqe unique (cellphone)
alter table parent add constraint UK_4l5d5138qhcio17s43thf9wvi unique (country)
alter table parent add constraint UK_jsu7h8a3oxqxtf8f2rctqeme2 unique (money)
alter table parent add constraint UK_abi9iuom01kx8p1stj4fonjja unique (municipality)
alter table parent add constraint UK_tkff6d2q9uuhuhs0gya31w046 unique (name)
alter table parent add constraint UK_85vv417hul65qf5pc2vapby6a unique (participation_certificate)
alter table parent add constraint UK_avdwqsbtfmhkbeebbgud4tdsr unique (phone)
alter table parent add constraint UK_b7xkmo1nur0s825h89bg1drtq unique (region)
alter table parent add constraint UK_ke5imqmbytnssxs3fvyujqg7e unique (surname)
alter table provider add constraint UK_bk81qmpiwpnva7s1gh5knn5pj unique (address)
alter table provider add constraint UK_fyjk9n6s0m6qtp4og3mynaum8 unique (address_number)
alter table provider add constraint UK_9lh072848jyaew1egu7veuen8 unique (avatar)
alter table provider add constraint UK_tleyg6c9xojpmijj5b64x078y unique (brand_name)
alter table provider add constraint UK_evc10lf42am1e0t6uiho18oe8 unique (country)
alter table provider add constraint UK_n5adpojh6flnxuk5k9p9jjo05 unique (distinctive_title)
alter table provider add constraint UK_sx1c62umih4fjybapyft4cgbs unique (identification_document)
alter table provider add constraint UK_gvvlw7nt6qfqdk6xjifxuhuk9 unique (legal_represantation)
alter table provider add constraint UK_8bamqw493eo44b9haf81bn9t5 unique (legal_represantation_email)
alter table provider add constraint UK_1fcl8f02ahx6o7kldb9ofqvos unique (legal_represantation_phone)
alter table provider add constraint UK_swh3klbcb345lieh28dfurv7f unique (municipality)
alter table provider add constraint UK_c1hep603uaiv2ayp549gv3vue unique (participation_certificate)
alter table provider add constraint UK_kjmyfidrx3360qfb37yg0m9ks unique (postal_code)
alter table provider add constraint UK_6j95dgbpy5mjuwy2euprkcvcf unique (public_finance_agency)
alter table provider add constraint UK_8924ncid47f256vwu6iscn5f6 unique (region)
alter table provider add constraint UK_b4rr5nbxbj5bt2mg4evvul5o7 unique (sector_type)
alter table provider add constraint UK_1f4wjaxf677ml63ofkcdojxba unique (tax_identification_number)
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)
alter table user add constraint UK_kiqfjabx9puw3p1eg7kily8kg unique (password)
alter table user add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)
alter table event add constraint FKi8bsvlthqr8lngsyshiqsodak foreign key (user_id) references user (id)
alter table parent add constraint FKor0no5wud03jeu63espilk64f foreign key (id) references user (id)
alter table provider add constraint FKr4s8yqw41cil21ix2dy04b796 foreign key (id) references user (id)
alter table role add constraint FKtmhh8ov8crluh7nn3uxdi841j foreign key (id) references user (id)
