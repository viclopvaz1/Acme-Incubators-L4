
    alter table `accounting_record` 
       drop 
       foreign key `FKj2bdai7wu5kc17dlturjf414p`;

    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `application` 
       drop 
       foreign key `FKk5ibe41quxsif8im882xv4afo`;

    alter table `application` 
       drop 
       foreign key `FKl4fp0cd8c008ma79n6w58xhk9`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `banner` 
       drop 
       foreign key `FKdocr1jjfgwx9ef5jbf675l360`;

    alter table `bookkeeper` 
       drop 
       foreign key FK_krvjp9eaqyapewl2igugbo9o8;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `credit_card` 
       drop 
       foreign key `FKa4pbn9v8sv66p46fsrke8ow89`;

    alter table `entrepreneur` 
       drop 
       foreign key FK_r6tqltqvrlh1cyy8rsj5pev1q;

    alter table `investment_round` 
       drop 
       foreign key `FKkj1l8c2ftn9c65y061me6t37j`;

    alter table `investor` 
       drop 
       foreign key FK_dcek5rr514s3rww0yy57vvnpq;

    alter table `patron` 
       drop 
       foreign key FK_8xx5nujhuio3advxc2freyu65;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `work_programme` 
       drop 
       foreign key `FK3nxyaik1cnvfdg02p9a8ibiko`;

    drop table if exists `accounting_record`;

    drop table if exists `administrator`;

    drop table if exists `anonymous`;

    drop table if exists `application`;

    drop table if exists `authenticated`;

    drop table if exists `banner`;

    drop table if exists `bookkeeper`;

    drop table if exists `challenge`;

    drop table if exists `configuration`;

    drop table if exists `consumer`;

    drop table if exists `credit_card`;

    drop table if exists `entrepreneur`;

    drop table if exists `inquirie`;

    drop table if exists `investment_round`;

    drop table if exists `investor`;

    drop table if exists `notice`;

    drop table if exists `overture`;

    drop table if exists `patron`;

    drop table if exists `provider`;

    drop table if exists `technology_record`;

    drop table if exists `tool_record`;

    drop table if exists `user_account`;

    drop table if exists `work_programme`;

    drop table if exists `cordon_bulletin`;

    drop table if exists `hibernate_sequence`;

    drop table if exists `lopez_bulletin`;

    drop table if exists `ruiz_bulletin`;
