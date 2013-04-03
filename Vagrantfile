Vagrant::Config.run do |config|

  config.vm.box = "precise64"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"

  # Boot with a GUI so you can see the screen. Good for debugging startup issues. (Default is headless)
  #config.vm.boot_mode = :gui

  config.vm.define "appserver" do |app|
    app.vm.network :hostonly, "33.33.33.10"
    app.vm.host_name = "psyk-appserver.local"

    app.vm.provision :puppet, :module_path => "puppet/modules" do |puppet|
      puppet.manifests_path = "puppet"
      puppet.manifest_file = "appserver.pp"
    end
  end

  config.vm.define "dbserver" do |db|
    db.vm.network :hostonly, "33.33.33.11"
    db.vm.host_name = "psyk-dbserver.local"
    db.vm.provision :puppet, :module_path => "puppet/modules" do |puppet|
      puppet.manifests_path = "puppet"
      puppet.manifest_file = "dbserver.pp"
    end
  end

end
