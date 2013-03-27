group { 'puppet':
  ensure => present,
}

exec { 'apt-get update': 
  command => '/usr/bin/apt-get update',
}

class { 'mysql': 
  require => Exec['apt-get update']
}

class { 'mysql::server':
  config_hash => { 'root_password' => 'wert', 'bind_address' => '0.0.0.0' }
}

class { 'mysql::java': 
}

mysql::db { 'psykdb':
  user     => 'dbuser',
  password => 'dbuser',
  host     => '%',
  grant    => ['all'],
}

