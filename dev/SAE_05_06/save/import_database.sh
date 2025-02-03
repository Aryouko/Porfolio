echo "DROP DATABASE wordpress;" | mysql
echo "CREATE DATABASE wordpress;" | mysql
echo "ALTER USER \"root\"@\"localhost\" IDENTIFIED BY \"password\";" | mysql
