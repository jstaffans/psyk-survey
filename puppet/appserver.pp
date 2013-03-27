group { 'puppet':
  ensure => present,
}

exec { 'apt-get update': 
  command => '/usr/bin/apt-get update',
}

include java

class { 'tomcat7':
  http_port => 8080
}
