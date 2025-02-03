<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the installation.
 * You don't have to use the website, you can copy this file to "wp-config.php"
 * and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * Database settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://developer.wordpress.org/advanced-administration/wordpress/wp-config/
 *
 * @package WordPress
 */

// ** Database settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'wordpress' );

/** Database username */
define( 'DB_USER', 'Thomas' );

/** Database password */
define( 'DB_PASSWORD', 'password' );

/** Database hostname */
define( 'DB_HOST', 'localhost' );

/** Database charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The database collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication unique keys and salts.
 *
 * Change these to different unique phrases! You can generate these using
 * the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}.
 *
 * You can change these at any point in time to invalidate all existing cookies.
 * This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         '{v,`@l0e%^)7_(n47)d!n51^od,8[]^T|H)T1frd/hN/x9s&VB%;w~z/AsG?[Qd ' );
define( 'SECURE_AUTH_KEY',  'u^O8{BH_y^)h(ppJ@e>g-GhWh6HZl3!*8?*$@7p3]zz$([=h3DA&dhAlxJ:3e)zu' );
define( 'LOGGED_IN_KEY',    'FQg];O<dW,y+hwK8MvmO$[8Oi@;ib:[xlE1/cfYiH3Y(ZcEMtjhbK1k1?,J9Dl_h' );
define( 'NONCE_KEY',        'id)Pq13@by3T}_W!mMmXP8|/0AMGxz$18Ufdh;u ;D*Ndt:H 9jhre[u>Cca8X!X' );
define( 'AUTH_SALT',        'uE z5V2F61s[kcG^_KH}>@- $O[7X/?/XDf>V@>s5s7zEFt`k~<=kGRVy;cWjFlP' );
define( 'SECURE_AUTH_SALT', '33flWwE3!UyZrWF]kkKi+RfJSLh-;6=CIxG);Gx~9PU1-twXU9Pkx1,7*:CXFZt>' );
define( 'LOGGED_IN_SALT',   '(euELM0H+sXCoCR$<xV!PqMoRAXi5w?mjaXGWY@IR$]t;Nz<xQfgmJ;cUTR8g6o*' );
define( 'NONCE_SALT',       'Kf4 5d>RInuq!@^;8lToVAGff}jfi|lp4Ph_5svlJ{n+HPCgYOv9V<FA?];5RmlS' );

/**#@-*/

/**
 * WordPress database table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://developer.wordpress.org/advanced-administration/debug/debug-wordpress/
 */
define( 'WP_DEBUG', false );

/* Add any custom values between this line and the "stop editing" line. */



/* That's all, stop editing! Happy publishing. */
define('FS_METHOD', 'direct');

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';
