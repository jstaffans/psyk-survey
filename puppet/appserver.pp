group { 'puppet':
  ensure => present,
}

exec { 'apt-get update': 
  command => '/usr/bin/apt-get update',
}

include java

class { 'tomcat7':
  http_port => 8080,
  mysql_user => 'dbuser',
  mysql_password => 'dbuser',
  mysql_url => 'jdbc:mysql://33.33.33.11/psykdb',
}
