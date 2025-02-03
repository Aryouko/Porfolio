rm -rf backup && mkdir -p backup/wordpress backup/database
mysqldump -u admin -p password > backup/database/wordpress.sql
cp -R wordpress/* backup/wordpress/