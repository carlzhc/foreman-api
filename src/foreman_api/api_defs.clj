(in-ns 'foreman-api.api)

(defapi list-all-architectures
  "List all architectures"
  :GET
  "/api/architectures")

(defapi list-all-architectures-for-operating-system
  "List all architectures for operating system"
  :GET
  "/api/operatingsystems/%s/architectures"
  operatingsystem-id)

(defapi show-an-architecture
  "Show an architecture"
  :GET
  "/api/architectures/%s"
  id)

(defapi create-an-architecture
  "Create an architecture"
  :POST
  "/api/architectures")

(defapi update-an-architecture
  "Update an architecture"
  :PUT
  "/api/architectures/%s"
  id)

(defapi delete-an-architecture
  "Delete an architecture"
  :DELETE
  "/api/architectures/%s"
  id)

(defapi list-all-audits
  "List all audits"
  :GET
  "/api/audits")

(defapi list-all-audits-for-a-given-host
  "List all audits for a given host"
  :GET
  "/api/hosts/%s/audits"
  host-id)

(defapi show-an-audit
  "Show an audit"
  :GET
  "/api/audits/%s"
  id)

(defapi list-external-authentication-sources
  "List external authentication sources"
  :GET
  "/api/auth_source_externals")

(defapi list-external-authentication-sources-per-location
  "List external authentication sources per location"
  :GET
  "/api/locations/%s/auth_source_externals"
  location-id)

(defapi list-external-authentication-sources-per-organization
  "List external authentication sources per organization"
  :GET
  "/api/organizations/%s/auth_source_externals"
  organization-id)

(defapi show-an-external-authentication-source
  "Show an external authentication source"
  :GET
  "/api/auth_source_externals/%s"
  id)

(defapi update-an-external-authentication-source
  "Update an external authentication source"
  :PUT
  "/api/auth_source_externals/%s"
  id)

(defapi list-internal-authentication-sources
  "List internal authentication sources"
  :GET
  "/api/auth_source_internals")

(defapi show-an-internal-authentication-source
  "Show an internal authentication source"
  :GET
  "/api/auth_source_internals/%s"
  id)

(defapi list-all-ldap-authentication-sources
  "List all LDAP authentication sources"
  :GET
  "/api/auth_source_ldaps")

(defapi list-ldap-authentication-sources-per-location
  "List LDAP authentication sources per location"
  :GET
  "/api/locations/%s/auth_source_ldaps"
  location-id)

(defapi list-ldap-authentication-sources-per-organization
  "List LDAP authentication sources per organization"
  :GET
  "/api/organizations/%s/auth_source_ldaps"
  organization-id)

(defapi show-an-ldap-authentication-source
  "Show an LDAP authentication source"
  :GET
  "/api/auth_source_ldaps/%s"
  id)

(defapi create-an-ldap-authentication-source
  "Create an LDAP authentication source"
  :POST
  "/api/auth_source_ldaps")

(defapi update-an-ldap-authentication-source
  "Update an LDAP authentication source"
  :PUT
  "/api/auth_source_ldaps/%s"
  id)

(defapi test-ldap-connection
  "Test LDAP connection"
  :PUT
  "/api/auth_source_ldaps/%s/test"
  id)

(defapi delete-an-ldap-authentication-source
  "Delete an LDAP authentication source"
  :DELETE
  "/api/auth_source_ldaps/%s"
  id)

(defapi list-all-authentication-sources
  "List all authentication sources"
  :GET
  "/api/auth_sources")

(defapi list-all-authentication-sources-per-location
  "List all authentication sources per location"
  :GET
  "/api/locations/%s/auth_sources"
  location-id)

(defapi list-all-authentication-sources-per-organization
  "List all authentication sources per organization"
  :GET
  "/api/organizations/%s/auth_sources"
  organization-id)

(defapi list-all-autosign-entries
  "List all autosign entries"
  :GET
  "/api/smart_proxies/smart_proxy_id/autosign")

(defapi create-autosign-entry
  "Create autosign entry"
  :POST
  "/api/smart_proxies/%s/autosign"
  smart-proxy-id)

(defapi delete-autosign-entry
  "Delete autosign entry"
  :DELETE
  "/api/smart_proxies/%s/autosign/%s"
  smart-proxy-id id)

(defapi list-all-bookmarks
  "List all bookmarks"
  :GET
  "/api/bookmarks")

(defapi show-a-bookmark
  "Show a bookmark"
  :GET
  "/api/bookmarks/%s"
  id)

(defapi create-a-bookmark
  "Create a bookmark"
  :POST
  "/api/bookmarks")

(defapi update-a-bookmark
  "Update a bookmark"
  :PUT
  "/api/bookmarks/%s"
  id)

(defapi delete-a-bookmark
  "Delete a bookmark"
  :DELETE
  "/api/bookmarks/%s"
  id)

(defapi list-all-global-parameters
  "List all global parameters"
  :GET
  "/api/common_parameters")

(defapi show-a-global-parameter
  "Show a global parameter"
  :GET
  "/api/common_parameters/%s"
  id)

(defapi create-a-global-parameter
  "Create a global parameter"
  :POST
  "/api/common_parameters")

(defapi update-a-global-parameter
  "Update a global parameter"
  :PUT
  "/api/common_parameters/%s"
  id)

(defapi delete-a-global-parameter
  "Delete a global parameter"
  :DELETE
  "/api/common_parameters/%s"
  id)

(defapi create-a-compute-attributes-set
  "Create a compute attributes set"
  :POST
  "/api/compute_resources/%s/compute_profiles/%s/compute_attributes"
  compute-resource-id compute-profile-id)

(defapi create-a-compute-attributes-set
  "Create a compute attributes set"
  :POST
  "/api/compute_profiles/%s/compute_resources/%s/compute_attributes"
  compute-profile-id compute-resource-id)

(defapi create-a-compute-attributes-set
  "Create a compute attributes set"
  :POST
  "/api/compute_resources/%s/compute_attributes"
  compute-resource-id)

(defapi create-a-compute-attributes-set
  "Create a compute attributes set"
  :POST
  "/api/compute_profiles/%s/compute_attributes"
  compute-profile-id)

(defapi create-a-compute-attributes-set
  "Create a compute attributes set"
  :POST
  "/api/compute_attributes")

(defapi update-a-compute-attributes-set
  "Update a compute attributes set"
  :PUT
  "/api/compute_resources/%s/compute_profiles/%s/compute_attributes/%s"
  compute-resource-id compute-profile-id id)

(defapi update-a-compute-attributes-set
  "Update a compute attributes set"
  :PUT
  "/api/compute_profiles/%s/compute_resources/%s/compute_attributes/%s"
  compute-profile-id compute-resource-id id)

(defapi update-a-compute-attributes-set
  "Update a compute attributes set"
  :PUT
  "/api/compute_resources/%s/compute_attributes/%s"
  compute-resource-id id)

(defapi update-a-compute-attributes-set
  "Update a compute attributes set"
  :PUT
  "/api/compute_profiles/%s/compute_attributes/%s"
  compute-profile-id id)

(defapi update-a-compute-attributes-set
  "Update a compute attributes set"
  :PUT
  "/api/compute_attributes/%s"
  id)

(defapi list-of-compute-profiles
  "List of compute profiles"
  :GET
  "/api/compute_profiles")

(defapi show-a-compute-profile
  "Show a compute profile"
  :GET
  "/api/compute_profiles/%s"
  id)

(defapi create-a-compute-profile
  "Create a compute profile"
  :POST
  "/api/compute_profiles")

(defapi update-a-compute-profile
  "Update a compute profile"
  :PUT
  "/api/compute_profiles/%s"
  id)

(defapi delete-a-compute-profile
  "Delete a compute profile"
  :DELETE
  "/api/compute_profiles/%s"
  id)

(defapi list-all-compute-resources
  "List all compute resources"
  :GET
  "/api/compute_resources")

(defapi show-a-compute-resource
  "Show a compute resource"
  :GET
  "/api/compute_resources/%s"
  id)

(defapi create-a-compute-resource
  "Create a compute resource"
  :POST
  "/api/compute_resources")

(defapi update-a-compute-resource
  "Update a compute resource"
  :PUT
  "/api/compute_resources/%s"
  id)

(defapi delete-a-compute-resource
  "Delete a compute resource"
  :DELETE
  "/api/compute_resources/%s"
  id)

(defapi list-available-images-for-a-compute-resource
  "List available images for a compute resource"
  :GET
  "/api/compute_resources/%s/available_images"
  id)

(defapi list-available-clusters-for-a-compute-resource
  "List available clusters for a compute resource"
  :GET
  "/api/compute_resources/%s/available_clusters"
  id)

(defapi list-available-flavors-for-a-compute-resource
  "List available flavors for a compute resource"
  :GET
  "/api/compute_resources/%s/available_flavors"
  id)

(defapi list-available-folders-for-a-compute-resource
  "List available folders for a compute resource"
  :GET
  "/api/compute_resources/%s/available_folders"
  id)

(defapi list-available-zone-for-a-compute-resource
  "List available zone for a compute resource"
  :GET
  "/api/compute_resources/%s/available_zones"
  id)

(defapi list-available-networks-for-a-compute-resource
  "List available networks for a compute resource"
  :GET
  "/api/compute_resources/%s/available_networks"
  id)

(defapi list-available-networks-for-a-compute-resource-cluster
  "List available networks for a compute resource cluster"
  :GET
  "/api/compute_resources/%s/available_clusters/%s/available_networks"
  id cluster-id)

(defapi list-resource-pools-for-a-compute-resource-cluster
  "List resource pools for a compute resource cluster"
  :GET
  "/api/compute_resources/%s/available_clusters/%s/available_resource_pools"
  id cluster-id)

(defapi list-storage-domains-for-a-compute-resource
  "List storage domains for a compute resource"
  :GET
  "/api/compute_resources/%s/available_storage_domains"
  id)

(defapi list-attributes-for-a-given-storage-domain
  "List attributes for a given storage domain"
  :GET
  "/api/compute_resources/%s/available_storage_domains/%s"
  id storage-domain)

(defapi list-storage-pods-for-a-compute-resource
  "List storage pods for a compute resource"
  :GET
  "/api/compute_resources/%s/available_storage_pods"
  id)

(defapi list-attributes-for-a-given-storage-pod
  "List attributes for a given storage pod"
  :GET
  "/api/compute_resources/%s/available_storage_pods/%s"
  id storage-pod)

(defapi list-available-security-groups-for-a-compute-resource
  "List available security groups for a compute resource"
  :GET
  "/api/compute_resources/%s/available_security_groups"
  id)

(defapi associate-vms-to-hosts
  "Associate VMs to Hosts"
  :PUT
  "/api/compute_resources/%s/associate"
  id)

(defapi refresh-compute-resource-cache
  "Refresh Compute Resource Cache"
  :PUT
  "/api/compute_resources/%s/refresh_cache"
  id)

(defapi list-of-config-groups
  "List of config groups"
  :GET
  "/api/config_groups")

(defapi show-a-config-group
  "Show a config group"
  :GET
  "/api/config_groups/%s"
  id)

(defapi create-a-config-group
  "Create a config group"
  :POST
  "/api/config_groups")

(defapi update-a-config-group
  "Update a config group"
  :PUT
  "/api/config_groups/%s"
  id)

(defapi delete-a-config-group
  "Delete a config group"
  :DELETE
  "/api/config_groups/%s"
  id)

(defapi list-all-reports
  "List all reports"
  :GET
  "/api/config_reports")

(defapi show-a-report
  "Show a report"
  :GET
  "/api/config_reports/%s"
  id)

(defapi create-a-report
  "Create a report"
  :POST
  "/api/config_reports")

(defapi delete-a-report
  "Delete a report"
  :DELETE
  "/api/config_reports/%s"
  id)

(defapi show-the-last-report-for-a-host
  "Show the last report for a host"
  :GET
  "/api/hosts/%s/config_reports/last"
  host-id)

(defapi list-provisioning-templates
  "List provisioning templates"
  :GET
  "/api/config_templates")

(defapi list-provisioning-templates-per-operating-system
  "List provisioning templates per operating system"
  :GET
  "/api/operatingsystems/%s/config_templates"
  operatingsystem-id)

(defapi list-provisioning-templates-per-location
  "List provisioning templates per location"
  :GET
  "/api/locations/%s/config_templates"
  location-id)

(defapi list-provisioning-templates-per-organization
  "List provisioning templates per organization"
  :GET
  "/api/organizations/%s/config_templates"
  organization-id)

(defapi show-provisioning-template-details
  "Show provisioning template details"
  :GET
  "/api/config_templates/%s"
  id)

(defapi create-a-provisioning-template
  "Create a provisioning template"
  :POST
  "/api/config_templates")

(defapi update-a-provisioning-template
  "Update a provisioning template"
  :PUT
  "/api/config_templates/%s"
  id)

(defapi list-of-config-templates-revision
  "List of config templates revision"
  :GET
  "/api/config_templates/revision")

(defapi delete-a-provisioning-template
  "Delete a provisioning template"
  :DELETE
  "/api/config_templates/%s"
  id)

(defapi update-the-default-pxe-menu-on-all-configured-tftp-servers
  "Update the default PXE menu on all configured TFTP servers"
  :POST
  "/api/config_templates/build_pxe_default")

(defapi clone-a-provision-template
  "Clone a provision template"
  :POST
  "/api/config_templates/%s/clone"
  id)

(defapi get-dashboard-details
  "Get dashboard details"
  :GET
  "/api/dashboard")

(defapi list-of-domains
  "List of domains"
  :GET
  "/api/domains")

(defapi list-of-domains-per-subnet
  "List of domains per subnet"
  :GET
  "/api/subnets/%s/domains"
  subnet-id)

(defapi list-of-domains-per-location
  "List of domains per location"
  :GET
  "/api/locations/%s/domains"
  location-id)

(defapi list-of-domains-per-organization
  "List of domains per organization"
  :GET
  "/api/organizations/%s/domains"
  organization-id)

(defapi show-a-domain
  "Show a domain"
  :GET
  "/api/domains/%s"
  id)

(defapi create-a-domain
  "Create a domain"
  :POST
  "/api/domains")

(defapi update-a-domain
  "Update a domain"
  :PUT
  "/api/domains/%s"
  id)

(defapi delete-a-domain
  "Delete a domain"
  :DELETE
  "/api/domains/%s"
  id)

(defapi import-puppet-classes-from-puppet-proxy
  "Import puppet classes from puppet proxy"
  :POST
  "/api/smart_proxies/%s/import_puppetclasses"
  id)

(defapi import-puppet-classes-from-puppet-proxy-for-an-environment
  "Import puppet classes from puppet proxy for an environment"
  :POST
  "/api/smart_proxies/%s/environments/%s/import_puppetclasses"
  smart-proxy-id id)

(defapi import-puppet-classes-from-puppet-proxy-for-an-environment
  "Import puppet classes from puppet proxy for an environment"
  :POST
  "/api/environments/%s/smart_proxies/%s/import_puppetclasses"
  environment-id id)

(defapi list-all-environments
  "List all environments"
  :GET
  "/api/environments")

(defapi list-environments-of-puppet-class
  "List environments of Puppet class"
  :GET
  "/api/puppetclasses/%s/environments"
  puppetclass-id)

(defapi list-environments-per-location
  "List environments per location"
  :GET
  "/api/locations/%s/environments"
  location-id)

(defapi list-environments-per-organization
  "List environments per organization"
  :GET
  "/api/organizations/%s/environments"
  organization-id)

(defapi show-an-environment
  "Show an environment"
  :GET
  "/api/environments/%s"
  id)

(defapi create-an-environment
  "Create an environment"
  :POST
  "/api/environments")

(defapi update-an-environment
  "Update an environment"
  :PUT
  "/api/environments/%s"
  id)

(defapi delete-an-environment
  "Delete an environment"
  :DELETE
  "/api/environments/%s"
  id)

(defapi list-all-external-user-groups-for-user-group
  "List all external user groups for user group"
  :GET
  "/api/usergroups/%s/external_usergroups"
  usergroup-id)

(defapi list-all-external-user-groups-for-ldap-authentication-source
  "List all external user groups for LDAP authentication source"
  :GET
  "/api/auth_source_ldaps/%s/external_usergroups"
  auth-source-ldap-id)

(defapi show-an-external-user-group-for-user-group
  "Show an external user group for user group"
  :GET
  "/api/usergroups/%s/external_usergroups/%s"
  usergroup-id id)

(defapi show-an-external-user-group-for-ldap-authentication-source
  "Show an external user group for LDAP authentication source"
  :GET
  "/api/auth_source_ldaps/%s/external_usergroups/%s"
  auth-source-ldap-id id)

(defapi create-an-external-user-group-linked-to-a-user-group
  "Create an external user group linked to a user group"
  :POST
  "/api/usergroups/%s/external_usergroups"
  usergroup-id)

(defapi update-external-user-group
  "Update external user group"
  :PUT
  "/api/usergroups/%s/external_usergroups/%s"
  usergroup-id id)

(defapi refresh-external-user-group
  "Refresh external user group"
  :PUT
  "/api/usergroups/%s/external_usergroups/%s/refresh"
  usergroup-id id)

(defapi delete-an-external-user-group
  "Delete an external user group"
  :DELETE
  "/api/usergroups/%s/external_usergroups/%s"
  usergroup-id id)

(defapi list-all-fact-values
  "List all fact values"
  :GET
  "/api/fact_values")

(defapi list-all-fact-values-of-a-given-host
  "List all fact values of a given host"
  :GET
  "/api/hosts/%s/facts"
  host-id)

(defapi list-all-filters
  "List all filters"
  :GET
  "/api/filters")

(defapi show-a-filter
  "Show a filter"
  :GET
  "/api/filters/%s"
  id)

(defapi create-a-filter
  "Create a filter"
  :POST
  "/api/filters")

(defapi update-a-filter
  "Update a filter"
  :PUT
  "/api/filters/%s"
  id)

(defapi delete-a-filter
  "Delete a filter"
  :DELETE
  "/api/filters/%s"
  id)

(defapi show-available-api-links
  "Show available API links"
  :GET
  "/api")

(defapi show-status
  "Show status"
  :GET
  "/api/status")

(defapi list-all-puppet-class-ids-for-host
  "List all Puppet class IDs for host"
  :GET
  "/api/hosts/%s/puppetclass_ids"
  host-id)

(defapi add-a-puppet-class-to-host
  "Add a Puppet class to host"
  :POST
  "/api/hosts/%s/puppetclass_ids"
  host-id)

(defapi remove-a-puppet-class-from-host
  "Remove a Puppet class from host"
  :DELETE
  "/api/hosts/%s/puppetclass_ids/%s"
  host-id id)

(defapi list-all-puppet-class-ids-for-host-group
  "List all Puppet class IDs for host group"
  :GET
  "/api/hostgroups/%s/puppetclass_ids"
  hostgroup-id)

(defapi add-a-puppet-class-to-host-group
  "Add a Puppet class to host group"
  :POST
  "/api/hostgroups/%s/puppetclass_ids"
  hostgroup-id)

(defapi remove-a-puppet-class-from-host-group
  "Remove a Puppet class from host group"
  :DELETE
  "/api/hostgroups/%s/puppetclass_ids/%s"
  hostgroup-id id)

(defapi list-all-host-groups
  "List all host groups"
  :GET
  "/api/hostgroups")

(defapi list-all-host-groups-for-a-puppet-class
  "List all host groups for a Puppet class"
  :GET
  "/api/puppetclasses/%s/hostgroups"
  puppetclass-id)

(defapi list-all-host-groups-per-location
  "List all host groups per location"
  :GET
  "/api/locations/%s/hostgroups"
  location-id)

(defapi list-all-host-groups-per-organization
  "List all host groups per organization"
  :GET
  "/api/organizations/%s/hostgroups"
  organization-id)

(defapi show-a-host-group
  "Show a host group"
  :GET
  "/api/hostgroups/%s"
  id)

(defapi create-a-host-group
  "Create a host group"
  :POST
  "/api/hostgroups")

(defapi update-a-host-group
  "Update a host group"
  :PUT
  "/api/hostgroups/%s"
  id)

(defapi delete-a-host-group
  "Delete a host group"
  :DELETE
  "/api/hostgroups/%s"
  id)

(defapi clone-a-host-group
  "Clone a host group"
  :POST
  "/api/hostgroups/%s/clone"
  id)

(defapi rebuild-orchestration-config
  "Rebuild orchestration config"
  :PUT
  "/api/hostgroups/%s/rebuild_config"
  id)

(defapi list-all-hosts
  "List all hosts"
  :GET
  "/api/hosts")

(defapi list-all-hosts-for-a-host-group
  "List all hosts for a host group"
  :GET
  "/api/hostgroups/%s/hosts"
  hostgroup-id)

(defapi list-hosts-per-location
  "List hosts per location"
  :GET
  "/api/locations/%s/hosts"
  location-id)

(defapi list-hosts-per-organization
  "List hosts per organization"
  :GET
  "/api/organizations/%s/hosts"
  organization-id)

(defapi list-hosts-per-environment
  "List hosts per environment"
  :GET
  "/api/environments/%s/hosts"
  environment-id)

(defapi show-a-host
  "Show a host"
  :GET
  "/api/hosts/%s"
  id)

(defapi create-a-host
  "Create a host"
  :POST
  "/api/hosts")

(defapi update-a-host
  "Update a host"
  :PUT
  "/api/hosts/%s"
  id)

(defapi delete-a-host
  "Delete a host"
  :DELETE
  "/api/hosts/%s"
  id)

(defapi get-enc-values-of-host
  "Get ENC values of host"
  :GET
  "/api/hosts/%s/enc"
  id)

(defapi get-configuration-status-of-host
  "Get configuration status of host"
  :GET
  "/api/hosts/%s/status"
  id)

(defapi get-status-of-host
  "Get status of host"
  :GET
  "/api/hosts/%s/status/%s"
  id type)

(defapi get-vm-attributes-of-host
  "Get vm attributes of host"
  :GET
  "/api/hosts/%s/vm_compute_attributes"
  id)

(defapi disassociate-the-host-from-a-vm
  "Disassociate the host from a VM"
  :PUT
  "/api/hosts/%s/disassociate"
  id)

(defapi run-a-power-operation-on-host
  "Run a power operation on host"
  :PUT
  "/api/hosts/%s/power"
  id)

(defapi boot-host-from-specified-device
  "Boot host from specified device"
  :PUT
  "/api/hosts/%s/boot"
  id)

(defapi upload-facts-for-a-host
  "Upload facts for a host, creating the host if required"
  :POST
  "/api/hosts/facts")

(defapi rebuild-orchestration-config
  "Rebuild orchestration config"
  :PUT
  "/api/hosts/%s/rebuild_config"
  id)

(defapi preview-rendered-provisioning-template-content
  "Preview rendered provisioning template content"
  :GET
  "/api/hosts/%s/template/%s"
  id kind)

(defapi list-of-http-proxies
  "List of HTTP Proxies"
  :GET
  "/api/http_proxies")

(defapi show-an-http-proxy
  "Show an HTTP Proxy"
  :GET
  "/api/http_proxies/%s"
  id)

(defapi create-an-http-proxy
  "Create an HTTP Proxy"
  :POST
  "/api/http_proxies")

(defapi update-an-http-proxy
  "Update an HTTP Proxy"
  :PUT
  "/api/http_proxies/%s"
  id)

(defapi delete-an-http-proxy
  "Delete an HTTP Proxy"
  :DELETE
  "/api/http_proxies/%s"
  id)

(defapi list-all-images-for-a-compute-resource
  "List all images for a compute resource"
  :GET
  "/api/compute_resources/%s/images"
  compute-resource-id)

(defapi list-all-images-for-operating-system
  "List all images for operating system"
  :GET
  "/api/operatingsystems/%s/images"
  operatingsystem-id)

(defapi list-all-images-for-architecture
  "List all images for architecture"
  :GET
  "/api/architectures/%s/images"
  architecture-id)

(defapi show-an-image
  "Show an image"
  :GET
  "/api/compute_resources/%s/images/%s"
  compute-resource-id id)

(defapi show-an-image
  "Show an image"
  :GET
  "/api/operatingsystems/%s/images/%s"
  operatingsystem-id id)

(defapi show-an-image
  "Show an image"
  :GET
  "/api/architectures/%s/images/%s"
  architecture-id id)

(defapi create-an-image
  "Create an image"
  :POST
  "/api/compute_resources/%s/images"
  compute-resource-id)

(defapi update-an-image
  "Update an image"
  :PUT
  "/api/compute_resources/%s/images/%s"
  compute-resource-id id)

(defapi delete-an-image
  "Delete an image"
  :DELETE
  "/api/compute_resources/%s/images/%s"
  compute-resource-id id)

(defapi list-all-interfaces-for-host
  "List all interfaces for host"
  :GET
  "/api/hosts/%s/interfaces"
  host-id)

(defapi list-all-interfaces-for-domain
  "List all interfaces for domain"
  :GET
  "/api/domains/%s/interfaces"
  domain-id)

(defapi list-all-interfaces-for-subnet
  "List all interfaces for subnet"
  :GET
  "/api/subnets/%s/interfaces"
  subnet-id)

(defapi show-an-interface-for-host
  "Show an interface for host"
  :GET
  "/api/hosts/%s/interfaces/%s"
  host-id id)

(defapi create-an-interface-on-a-host
  "Create an interface on a host"
  :POST
  "/api/hosts/%s/interfaces"
  host-id)

(defapi update-a-host-interface
  "Update a host interface"
  :PUT
  "/api/hosts/%s/interfaces/%s"
  host-id id)

(defapi delete-a-host-interface
  "Delete a host interface"
  :DELETE
  "/api/hosts/%s/interfaces/%s"
  host-id id)

(defapi list-all-locations
  "List all locations"
  :GET
  "/api/locations")

(defapi show-a-location
  "Show a location"
  :GET
  "/api/locations/%s"
  id)

(defapi create-a-location
  "Create a location"
  :POST
  "/api/locations")

(defapi update-a-location
  "Update a location"
  :PUT
  "/api/locations/%s"
  id)

(defapi delete-a-location
  "Delete a location"
  :DELETE
  "/api/locations/%s"
  id)

(defapi list-of-email-notifications
  "List of email notifications"
  :GET
  "/api/mail_notifications")

(defapi show-an-email-notification
  "Show an email notification"
  :GET
  "/api/mail_notifications/%s"
  id)

(defapi list-all-installation-media
  "List all installation media"
  :GET
  "/api/media")

(defapi list-all-media-for-an-operating-system
  "List all media for an operating system"
  :GET
  "/api/operatingsystems/%s/media"
  operatingsystem-id)

(defapi list-all-media-per-location
  "List all media per location"
  :GET
  "/api/locations/%s/media"
  location-id)

(defapi list-all-media-per-organization
  "List all media per organization"
  :GET
  "/api/organizations/%s/media"
  organization-id)

(defapi show-a-medium
  "Show a medium"
  :GET
  "/api/media/%s"
  id)

(defapi create-a-medium
  "Create a medium"
  :POST
  "/api/media")

(defapi update-a-medium
  "Update a medium"
  :PUT
  "/api/media/%s"
  id)

(defapi delete-a-medium
  "Delete a medium"
  :DELETE
  "/api/media/%s"
  id)

(defapi list-all-hardware-models
  "List all hardware models"
  :GET
  "/api/models")

(defapi show-a-hardware-model
  "Show a hardware model"
  :GET
  "/api/models/%s"
  id)

(defapi create-a-hardware-model
  "Create a hardware model"
  :POST
  "/api/models")

(defapi update-a-hardware-model
  "Update a hardware model"
  :PUT
  "/api/models/%s"
  id)

(defapi delete-a-hardware-model
  "Delete a hardware model"
  :DELETE
  "/api/models/%s"
  id)

(defapi list-all-operating-systems
  "List all operating systems"
  :GET
  "/api/operatingsystems")

(defapi list-all-operating-systems-for-nested-architecture
  "List all operating systems for nested architecture"
  :GET
  "/api/architectures/%s/operatingsystems"
  architecture-id)

(defapi list-all-operating-systems-for-nested-medium
  "List all operating systems for nested medium"
  :GET
  "/api/media/%s/operatingsystems"
  medium-id)

(defapi list-all-operating-systems-for-nested-partition-table
  "List all operating systems for nested partition table"
  :GET
  "/api/ptables/%s/operatingsystems"
  ptable-id)

(defapi list-all-operating-systems-for-nested-provisioning-template
  "List all operating systems for nested provisioning template"
  :GET
  "/api/config_templates/%s/operatingsystems"
  config-template-id)

(defapi list-all-operating-systems-for-nested-provisioning-template
  "List all operating systems for nested provisioning template"
  :GET
  "/api/provisioning_templates/%s/operatingsystems"
  provisioning-template-id)

(defapi show-an-operating-system
  "Show an operating system"
  :GET
  "/api/operatingsystems/%s"
  id)

(defapi create-an-operating-system
  "Create an operating system"
  :POST
  "/api/operatingsystems")

(defapi update-an-operating-system
  "Update an operating system"
  :PUT
  "/api/operatingsystems/%s"
  id)

(defapi delete-an-operating-system
  "Delete an operating system"
  :DELETE
  "/api/operatingsystems/%s"
  id)

(defapi list-boot-files-for-an-operating-system
  "List boot files for an operating system"
  :GET
  "/api/operatingsystems/%s/bootfiles"
  id)

(defapi list-all-organizations
  "List all organizations"
  :GET
  "/api/organizations")

(defapi show-an-organization
  "Show an organization"
  :GET
  "/api/organizations/%s"
  id)

(defapi create-an-organization
  "Create an organization"
  :POST
  "/api/organizations")

(defapi update-an-organization
  "Update an organization"
  :PUT
  "/api/organizations/%s"
  id)

(defapi delete-an-organization
  "Delete an organization"
  :DELETE
  "/api/organizations/%s"
  id)

(defapi list-default-templates-combinations-for-an-operating-system
  "List default templates combinations for an operating system"
  :GET
  "/api/operatingsystems/%s/os_default_templates"
  operatingsystem-id)

(defapi list-operating-systems-where-this-template-is-set-as-a-default
  "List operating systems where this template is set as a default"
  :GET
  "/api/config_templates/%s/os_default_templates"
  config-template-id)

(defapi list-operating-systems-where-this-template-is-set-as-a-default
  "List operating systems where this template is set as a default"
  :GET
  "/api/provisioning_templates/%s/os_default_templates"
  provisioning-template-id)

(defapi show-a-default-template-combination-for-an-operating-system
  "Show a default template combination for an operating system"
  :GET
  "/api/operatingsystems/%s/os_default_templates/%s"
  operatingsystem-id id)

(defapi create-a-default-template-combination-for-an-operating-system
  "Create a default template combination for an operating system"
  :POST
  "/api/operatingsystems/%s/os_default_templates"
  operatingsystem-id)

(defapi update-a-default-template-combination-for-an-operating-system
  "Update a default template combination for an operating system"
  :PUT
  "/api/operatingsystems/%s/os_default_templates/%s"
  operatingsystem-id id)

(defapi delete-a-default-template-combination-for-an-operating-system
  "Delete a default template combination for an operating system"
  :DELETE
  "/api/operatingsystems/%s/os_default_templates/%s"
  operatingsystem-id id)

(defapi list-of-override-values-for-a-specific-smart-variable
  "List of override values for a specific smart variable"
  :GET
  "/api/smart_variables/%s/override_values"
  smart-variable-id)

(defapi list-of-override-values-for-a-specific-smart-class-parameter
  "List of override values for a specific smart class parameter"
  :GET
  "/api/smart_class_parameters/%s/override_values"
  smart-class-parameter-id)

(defapi show-an-override-value-for-a-specific-smart-variable
  "Show an override value for a specific smart variable"
  :GET
  "/api/smart_variables/%s/override_values/%s"
  smart-variable-id id)

(defapi show-an-override-value-for-a-specific-smart-class-parameter
  "Show an override value for a specific smart class parameter"
  :GET
  "/api/smart_class_parameters/%s/override_values/%s"
  smart-class-parameter-id id)

(defapi create-an-override-value-for-a-specific-smart-variable
  "Create an override value for a specific smart variable"
  :POST
  "/api/smart_variables/%s/override_values"
  smart-variable-id)

(defapi create-an-override-value-for-a-specific-smart-class-parameter
  "Create an override value for a specific smart class parameter"
  :POST
  "/api/smart_class_parameters/%s/override_values"
  smart-class-parameter-id)

(defapi update-an-override-value-for-a-specific-smart-variable
  "Update an override value for a specific smart variable"
  :PUT
  "/api/smart_variables/%s/override_values/%s"
  smart-variable-id id)

(defapi update-an-override-value-for-a-specific-smart-class-parameter
  "Update an override value for a specific smart class parameter"
  :PUT
  "/api/smart_class_parameters/%s/override_values/%s"
  smart-class-parameter-id id)

(defapi delete-an-override-value-for-a-specific-smart-variable
  "Delete an override value for a specific smart variable"
  :DELETE
  "/api/smart_variables/%s/override_values/%s"
  smart-variable-id id)

(defapi delete-an-override-value-for-a-specific-smart-class-parameter
  "Delete an override value for a specific smart class parameter"
  :DELETE
  "/api/smart_class_parameters/%s/override_values/%s"
  smart-class-parameter-id id)

(defapi list-all-parameters-for-a-host
  "List all parameters for a host"
  :GET
  "/api/hosts/%s/parameters"
  host-id)

(defapi list-all-parameters-for-a-host-group
  "List all parameters for a host group"
  :GET
  "/api/hostgroups/%s/parameters"
  hostgroup-id)

(defapi list-all-parameters-for-a-domain
  "List all parameters for a domain"
  :GET
  "/api/domains/%s/parameters"
  domain-id)

(defapi list-all-parameters-for-an-operating-system
  "List all parameters for an operating system"
  :GET
  "/api/operatingsystems/%s/parameters"
  operatingsystem-id)

(defapi list-all-parameters-for-a-location
  "List all parameters for a location"
  :GET
  "/api/locations/%s/parameters"
  location-id)

(defapi list-all-parameters-for-an-organization
  "List all parameters for an organization"
  :GET
  "/api/organizations/%s/parameters"
  organization-id)

(defapi list-all-parameters-for-a-subnet
  "List all parameters for a subnet"
  :GET
  "/api/subnets/%s/parameters"
  subnet-id)

(defapi show-a-nested-parameter-for-a-host
  "Show a nested parameter for a host"
  :GET
  "/api/hosts/%s/parameters/%s"
  host-id id)

(defapi show-a-nested-parameter-for-a-host-group
  "Show a nested parameter for a host group"
  :GET
  "/api/hostgroups/%s/parameters/%s"
  hostgroup-id id)

(defapi show-a-nested-parameter-for-a-domain
  "Show a nested parameter for a domain"
  :GET
  "/api/domains/%s/parameters/%s"
  domain-id id)

(defapi show-a-nested-parameter-for-an-operating-system
  "Show a nested parameter for an operating system"
  :GET
  "/api/operatingsystems/%s/parameters/%s"
  operatingsystem-id id)

(defapi show-a-nested-parameter-for-a-location
  "Show a nested parameter for a location"
  :GET
  "/api/locations/%s/parameters/%s"
  location-id id)

(defapi show-a-nested-parameter-for-an-organization
  "Show a nested parameter for an organization"
  :GET
  "/api/organizations/%s/parameters/%s"
  organization-id id)

(defapi show-a-nested-parameter-for-a-subnet
  "Show a nested parameter for a subnet"
  :GET
  "/api/subnets/%s/parameters/%s"
  subnet-id id)

(defapi create-a-nested-parameter-for-a-host
  "Create a nested parameter for a host"
  :POST
  "/api/hosts/%s/parameters"
  host-id)

(defapi create-a-nested-parameter-for-a-host-group
  "Create a nested parameter for a host group"
  :POST
  "/api/hostgroups/%s/parameters"
  hostgroup-id)

(defapi create-a-nested-parameter-for-a-domain
  "Create a nested parameter for a domain"
  :POST
  "/api/domains/%s/parameters"
  domain-id)

(defapi create-a-nested-parameter-for-an-operating-system
  "Create a nested parameter for an operating system"
  :POST
  "/api/operatingsystems/%s/parameters"
  operatingsystem-id)

(defapi create-a-nested-parameter-for-a-location
  "Create a nested parameter for a location"
  :POST
  "/api/locations/%s/parameters"
  location-id)

(defapi create-a-nested-parameter-for-an-organization
  "Create a nested parameter for an organization"
  :POST
  "/api/organizations/%s/parameters"
  organization-id)

(defapi create-a-nested-parameter-for-a-subnet
  "Create a nested parameter for a subnet"
  :POST
  "/api/subnets/%s/parameters"
  subnet-id)

(defapi update-a-nested-parameter-for-a-host
  "Update a nested parameter for a host"
  :PUT
  "/api/hosts/%s/parameters/%s"
  host-id id)

(defapi update-a-nested-parameter-for-a-host-group
  "Update a nested parameter for a host group"
  :PUT
  "/api/hostgroups/%s/parameters/%s"
  hostgroup-id id)

(defapi update-a-nested-parameter-for-a-domain
  "Update a nested parameter for a domain"
  :PUT
  "/api/domains/%s/parameters/%s"
  domain-id id)

(defapi update-a-nested-parameter-for-an-operating-system
  "Update a nested parameter for an operating system"
  :PUT
  "/api/operatingsystems/%s/parameters/%s"
  operatingsystem-id id)

(defapi update-a-nested-parameter-for-a-location
  "Update a nested parameter for a location"
  :PUT
  "/api/locations/%s/parameters/%s"
  location-id id)

(defapi update-a-nested-parameter-for-an-organization
  "Update a nested parameter for an organization"
  :PUT
  "/api/organizations/%s/parameters/%s"
  organization-id id)

(defapi update-a-nested-parameter-for-a-subnet
  "Update a nested parameter for a subnet"
  :PUT
  "/api/subnets/%s/parameters/%s"
  subnet-id id)

(defapi delete-a-nested-parameter-for-a-host
  "Delete a nested parameter for a host"
  :DELETE
  "/api/hosts/%s/parameters/%s"
  host-id id)

(defapi delete-a-nested-parameter-for-a-host-group
  "Delete a nested parameter for a host group"
  :DELETE
  "/api/hostgroups/%s/parameters/%s"
  hostgroup-id id)

(defapi delete-a-nested-parameter-for-a-domain
  "Delete a nested parameter for a domain"
  :DELETE
  "/api/domains/%s/parameters/%s"
  domain-id id)

(defapi delete-a-nested-parameter-for-an-operating-system
  "Delete a nested parameter for an operating system"
  :DELETE
  "/api/operatingsystems/%s/parameters/%s"
  operatingsystem-id id)

(defapi delete-a-nested-parameter-for-a-location
  "Delete a nested parameter for a location"
  :DELETE
  "/api/locations/%s/parameters/%s"
  location-id id)

(defapi delete-a-nested-parameter-for-an-organization
  "Delete a nested parameter for an organization"
  :DELETE
  "/api/organizations/%s/parameters/%s"
  organization-id id)

(defapi delete-a-nested-parameter-for-a-subnet
  "Delete a nested parameter for a subnet"
  :DELETE
  "/api/subnets/%s/parameters/%s"
  subnet-id id)

(defapi delete-all-nested-parameters-for-a-host
  "Delete all nested parameters for a host"
  :DELETE
  "/api/hosts/%s/parameters"
  host-id)

(defapi delete-all-nested-parameters-for-a-host-group
  "Delete all nested parameters for a host group"
  :DELETE
  "/api/hostgroups/%s/parameters"
  hostgroup-id)

(defapi delete-all-nested-parameters-for-a-domain
  "Delete all nested parameters for a domain"
  :DELETE
  "/api/domains/%s/parameters"
  domain-id)

(defapi delete-all-nested-parameters-for-an-operating-system
  "Delete all nested parameters for an operating system"
  :DELETE
  "/api/operatingsystems/%s/parameters"
  operatingsystem-id)

(defapi delete-all-nested-parameter-for-a-location
  "Delete all nested parameter for a location"
  :DELETE
  "/api/locations/%s/parameters"
  location-id)

(defapi delete-all-nested-parameter-for-an-organization
  "Delete all nested parameter for an organization"
  :DELETE
  "/api/organizations/%s/parameters"
  organization-id)

(defapi delete-all-nested-parameters-for-a-subnet
  "Delete all nested parameters for a subnet"
  :DELETE
  "/api/subnets/%s/parameters"
  subnet-id)

(defapi list-all-permissions
  "List all permissions"
  :GET
  "/api/permissions")

(defapi show-a-permission
  "Show a permission"
  :GET
  "/api/permissions/%s"
  id)

(defapi list-available-resource-types
  "List available resource types"
  :GET
  "/api/permissions/resource_types")

(defapi list-all-personal-access-tokens-for-a-user
  "List all Personal Access Tokens for a user"
  :GET
  "/api/users/%s/personal_access_tokens"
  user-id)

(defapi show-a-personal-access-token-for-a-user
  "Show a Personal Access Token for a user"
  :GET
  "/api/users/%s/personal_access_tokens/%s"
  user-id id)

(defapi create-a-personal-access-token-for-a-user
  "Create a Personal Access Token for a user"
  :POST
  "/api/users/%s/personal_access_tokens"
  user-id)

(defapi revoke-a-personal-access-token-for-a-user
  "Revoke a Personal Access Token for a user"
  :DELETE
  "/api/users/%s/personal_access_tokens/%s"
  user-id id)

(defapi list-installed-plugins
  "List installed plugins"
  :GET
  "/api/plugins")

(defapi list-provisioning-templates
  "List provisioning templates"
  :GET
  "/api/provisioning_templates")

(defapi list-provisioning-templates-per-operating-system
  "List provisioning templates per operating system"
  :GET
  "/api/operatingsystems/%s/provisioning_templates"
  operatingsystem-id)

(defapi list-provisioning-templates-per-location
  "List provisioning templates per location"
  :GET
  "/api/locations/%s/provisioning_templates"
  location-id)

(defapi list-provisioning-templates-per-organization
  "List provisioning templates per organization"
  :GET
  "/api/organizations/%s/provisioning_templates"
  organization-id)

(defapi show-provisioning-template-details
  "Show provisioning template details"
  :GET
  "/api/provisioning_templates/%s"
  id)

(defapi create-a-provisioning-template
  "Create a provisioning template"
  :POST
  "/api/provisioning_templates")

(defapi import-a-provisioning-template
  "Import a provisioning template"
  :POST
  "/api/provisioning_templates/import")

(defapi update-a-provisioning-template
  "Update a provisioning template"
  :PUT
  "/api/provisioning_templates/%s"
  id)

(defapi list-of-provisioning-templates-revision
  "List of provisioning templates revision"
  :GET
  "/api/provisioning_templates/revision")

(defapi delete-a-provisioning-template
  "Delete a provisioning template"
  :DELETE
  "/api/provisioning_templates/%s"
  id)

(defapi update-the-default-pxe-menu-on-all-configured-tftp-servers
  "Update the default PXE menu on all configured TFTP servers"
  :POST
  "/api/provisioning_templates/build_pxe_default")

(defapi clone-a-provision-template
  "Clone a provision template"
  :POST
  "/api/provisioning_templates/%s/clone"
  id)

(defapi export-a-provisioning-template-to-erb
  "Export a provisioning template to ERB"
  :GET
  "/api/provisioning_templates/%s/export"
  id)

(defapi list-all-partition-tables
  "List all partition tables"
  :GET
  "/api/ptables")

(defapi list-all-partition-tables-for-an-operating-system
  "List all partition tables for an operating system"
  :GET
  "/api/operatingsystems/%s/ptables"
  operatingsystem-id)

(defapi list-all-partition-tables-per-location
  "List all partition tables per location"
  :GET
  "/api/locations/%s/ptables"
  location-id)

(defapi list-all-partition-tables-per-organization
  "List all partition tables per organization"
  :GET
  "/api/organizations/%s/ptables"
  organization-id)

(defapi show-a-partition-table
  "Show a partition table"
  :GET
  "/api/ptables/%s"
  id)

(defapi create-a-partition-table
  "Create a partition table"
  :POST
  "/api/ptables")

(defapi import-a-provisioning-template
  "Import a provisioning template"
  :POST
  "/api/ptables/import")

(defapi list-of-ptables-revision
  "List of ptables revision"
  :GET
  "/api/ptables/revision")

(defapi update-a-partition-table
  "Update a partition table"
  :PUT
  "/api/ptables/%s"
  id)

(defapi delete-a-partition-table
  "Delete a partition table"
  :DELETE
  "/api/ptables/%s"
  id)

(defapi clone-a-template
  "Clone a template"
  :POST
  "/api/ptables/%s/clone"
  id)

(defapi export-a-partition-template-to-erb
  "Export a partition template to ERB"
  :GET
  "/api/ptables/%s/export"
  id)

(defapi force-a-puppet-agent-run-on-the-host
  "Force a Puppet agent run on the host"
  :PUT
  "/api/hosts/%s/puppetrun"
  id)

(defapi list-all-puppet-classes
  "List all Puppet classes"
  :GET
  "/api/puppetclasses")

(defapi list-all-puppet-classes-for-a-host
  "List all Puppet classes for a host"
  :GET
  "/api/hosts/%s/puppetclasses"
  host-id)

(defapi list-all-puppet-classes-for-a-host-group
  "List all Puppet classes for a host group"
  :GET
  "/api/hostgroups/%s/puppetclasses"
  hostgroup-id)

(defapi list-all-puppet-classes-for-an-environment
  "List all Puppet classes for an environment"
  :GET
  "/api/environments/%s/puppetclasses"
  environment-id)

(defapi show-a-puppet-class
  "Show a Puppet class"
  :GET
  "/api/puppetclasses/%s"
  id)

(defapi show-a-puppet-class-for-host
  "Show a Puppet class for host"
  :GET
  "/api/hosts/%s/puppetclasses/%s"
  host-id id)

(defapi show-a-puppet-class-for-a-host-group
  "Show a Puppet class for a host group"
  :GET
  "/api/hostgroups/%s/puppetclasses/%s"
  hostgroup-id id)

(defapi show-a-puppet-class-for-an-environment
  "Show a Puppet class for an environment"
  :GET
  "/api/environments/%s/puppetclasses/%s"
  environment-id id)

(defapi create-a-puppet-class
  "Create a Puppet class"
  :POST
  "/api/puppetclasses")

(defapi update-a-puppet-class
  "Update a Puppet class"
  :PUT
  "/api/puppetclasses/%s"
  id)

(defapi delete-a-puppet-class
  "Delete a Puppet class"
  :DELETE
  "/api/puppetclasses/%s"
  id)

(defapi list-of-realms
  "List of realms"
  :GET
  "/api/realms")

(defapi show-a-realm
  "Show a realm"
  :GET
  "/api/realms/%s"
  id)

(defapi create-a-realm
  "Create a realm"
  :POST
  "/api/realms")

(defapi update-a-realm
  "Update a realm"
  :PUT
  "/api/realms/%s"
  id)

(defapi delete-a-realm
  "Delete a realm"
  :DELETE
  "/api/realms/%s"
  id)

(defapi list-all-report-templates
  "List all report templates"
  :GET
  "/api/report_templates")

(defapi list-all-report-templates-per-location
  "List all report templates per location"
  :GET
  "/api/locations/%s/report_templates"
  location-id)

(defapi list-all-report-templates-per-organization
  "List all report templates per organization"
  :GET
  "/api/organizations/%s/report_templates"
  organization-id)

(defapi show-a-report-template
  "Show a report template"
  :GET
  "/api/report_templates/%s"
  id)

(defapi create-a-report-template
  "Create a report template"
  :POST
  "/api/report_templates")

(defapi import-a-report-template
  "Import a report template"
  :POST
  "/api/report_templates/import")

(defapi list-of-report-templates-revision
  "List of report templates revision"
  :GET
  "/api/report_templates/revision")

(defapi update-a-report-template
  "Update a report template"
  :PUT
  "/api/report_templates/%s"
  id)

(defapi delete-a-report-template
  "Delete a report template"
  :DELETE
  "/api/report_templates/%s"
  id)

(defapi clone-a-template
  "Clone a template"
  :POST
  "/api/report_templates/%s/clone"
  id)

(defapi export-a-report-template-to-erb
  "Export a report template to ERB"
  :GET
  "/api/report_templates/%s/export"
  id)

(defapi generate-a-report-template
  "Generate a report template"
  :POST
  "/api/report_templates/%s/generate"
  id)

(defapi list-all-reports
  "List all reports"
  :GET
  "/api/reports")

(defapi show-a-report
  "Show a report"
  :GET
  "/api/reports/%s"
  id)

(defapi create-a-report
  "Create a report"
  :POST
  "/api/reports")

(defapi delete-a-report
  "Delete a report"
  :DELETE
  "/api/reports/%s"
  id)

(defapi show-the-last-report-for-a-host
  "Show the last report for a host"
  :GET
  "/api/hosts/%s/reports/last"
  host-id)

(defapi list-all-roles
  "List all roles"
  :GET
  "/api/roles")

(defapi show-a-role
  "Show a role"
  :GET
  "/api/roles/%s"
  id)

(defapi create-a-role
  "Create a role"
  :POST
  "/api/roles")

(defapi update-a-role
  "Update a role"
  :PUT
  "/api/roles/%s"
  id)

(defapi delete-a-role
  "Delete a role"
  :DELETE
  "/api/roles/%s"
  id)

(defapi clone-a-role
  "Clone a role"
  :POST
  "/api/roles/%s/clone"
  id)

(defapi list-all-settings
  "List all settings"
  :GET
  "/api/settings")

(defapi show-a-setting
  "Show a setting"
  :GET
  "/api/settings/%s"
  id)

(defapi update-a-setting
  "Update a setting"
  :PUT
  "/api/settings/%s"
  id)

(defapi list-all-smart-class-parameters
  "List all smart class parameters"
  :GET
  "/api/smart_class_parameters")

(defapi list-of-smart-class-parameters-for-a-specific-host
  "List of smart class parameters for a specific host"
  :GET
  "/api/hosts/%s/smart_class_parameters"
  host-id)

(defapi list-of-smart-class-parameters-for-a-specific-host-group
  "List of smart class parameters for a specific host group"
  :GET
  "/api/hostgroups/%s/smart_class_parameters"
  hostgroup-id)

(defapi list-of-smart-class-parameters-for-a-specific-puppet-class
  "List of smart class parameters for a specific Puppet class"
  :GET
  "/api/puppetclasses/%s/smart_class_parameters"
  puppetclass-id)

(defapi list-of-smart-class-parameters-for-a-specific-environment
  "List of smart class parameters for a specific environment"
  :GET
  "/api/environments/%s/smart_class_parameters"
  environment-id)

(defapi list-of-smart-class-parameters-for-a-specific-environment-puppet-class-combination
  "List of smart class parameters for a specific environment/Puppet class combination"
  :GET
  "/api/environments/%s/puppetclasses/%s/smart_class_parameters"
  environment-id puppetclass-id)

(defapi show-a-smart-class-parameter
  "Show a smart class parameter"
  :GET
  "/api/smart_class_parameters/%s"
  id)

(defapi update-a-smart-class-parameter
  "Update a smart class parameter"
  :PUT
  "/api/smart_class_parameters/%s"
  id)

(defapi import-puppet-classes-from-puppet-proxy
  "Import puppet classes from puppet proxy"
  :POST
  "/api/smart_proxies/%s/import_puppetclasses"
  id)

(defapi import-puppet-classes-from-puppet-proxy-for-an-environment
  "Import puppet classes from puppet proxy for an environment"
  :POST
  "/api/smart_proxies/%s/environments/%s/import_puppetclasses"
  smart-proxy-id id)

(defapi import-puppet-classes-from-puppet-proxy-for-an-environment
  "Import puppet classes from puppet proxy for an environment"
  :POST
  "/api/environments/%s/smart_proxies/%s/import_puppetclasses"
  environment-id id)

(defapi list-all-smart-proxies
  "List all smart proxies"
  :GET
  "/api/smart_proxies")

(defapi show-a-smart-proxy
  "Show a smart proxy"
  :GET
  "/api/smart_proxies/%s"
  id)

(defapi create-a-smart-proxy
  "Create a smart proxy"
  :POST
  "/api/smart_proxies")

(defapi update-a-smart-proxy
  "Update a smart proxy"
  :PUT
  "/api/smart_proxies/%s"
  id)

(defapi delete-a-smart-proxy
  "Delete a smart proxy"
  :DELETE
  "/api/smart_proxies/%s"
  id)

(defapi refresh-smart-proxy-features
  "Refresh smart proxy features"
  :PUT
  "/api/smart_proxies/%s/refresh"
  id)

(defapi list-all-smart-variables
  "List all smart variables"
  :GET
  "/api/smart_variables")

(defapi list-of-smart-variables-for-a-specific-host
  "List of smart variables for a specific host"
  :GET
  "/api/hosts/%s/smart_variables"
  host-id)

(defapi list-of-smart-variables-for-a-specific-host-group
  "List of smart variables for a specific host group"
  :GET
  "/api/hostgroups/%s/smart_variables"
  hostgroup-id)

(defapi list-of-smart-variables-for-a-specific-puppet-class
  "List of smart variables for a specific Puppet class"
  :GET
  "/api/puppetclasses/%s/smart_variables"
  puppetclass-id)

(defapi show-a-smart-variable
  "Show a smart variable"
  :GET
  "/api/smart_variables/%s"
  id)

(defapi create-a-smart-variable
  "Create a smart variable"
  :POST
  "/api/smart_variables")

(defapi update-a-smart-variable
  "Update a smart variable"
  :PUT
  "/api/smart_variables/%s"
  id)

(defapi delete-a-smart-variable
  "Delete a smart variable"
  :DELETE
  "/api/smart_variables/%s"
  id)

(defapi list-all-ssh-keys-for-a-user
  "List all SSH keys for a user"
  :GET
  "/api/users/%s/ssh_keys"
  user-id)

(defapi show-an-ssh-key-from-a-user
  "Show an SSH key from a user"
  :GET
  "/api/users/%s/ssh_keys/%s"
  user-id id)

(defapi add-an-ssh-key-for-a-user
  "Add an SSH key for a user"
  :POST
  "/api/users/%s/ssh_keys"
  user-id)

(defapi delete-an-ssh-key-for-a-user
  "Delete an SSH key for a user"
  :DELETE
  "/api/users/%s/ssh_keys/%s"
  user-id id)

(defapi get-statistics
  "Get statistics"
  :GET
  "/api/statistics")

(defapi list-of-subnets
  "List of subnets"
  :GET
  "/api/subnets")

(defapi list-of-subnets-for-a-domain
  "List of subnets for a domain"
  :GET
  "/api/domains/%s/subnets"
  domain-id)

(defapi list-of-subnets-per-location
  "List of subnets per location"
  :GET
  "/api/locations/%s/subnets"
  location-id)

(defapi list-of-subnets-per-organization
  "List of subnets per organization"
  :GET
  "/api/organizations/%s/subnets"
  organization-id)

(defapi show-a-subnet
  "Show a subnet"
  :GET
  "/api/subnets/%s"
  id)

(defapi create-a-subnet
  "Create a subnet"
  :POST
  "/api/subnets")

(defapi update-a-subnet
  "Update a subnet"
  :PUT
  "/api/subnets/%s"
  id)

(defapi delete-a-subnet
  "Delete a subnet"
  :DELETE
  "/api/subnets/%s"
  id)

(defapi provides-an-unused-ip-address-in-this-subnet
  "Provides an unused IP address in this subnet"
  :GET
  "/api/subnets/%s/freeip"
  id)

(defapi list-of-table-preferences-for-a-user
  "List of table preferences for a user"
  :GET
  "/api/users/%s/table_preferences"
  user-id)

(defapi table-preference-details-of-a-given-table
  "Table preference details of a given table"
  :GET
  "/api/users/%s/table_preferences/%s"
  user-id name)

(defapi creates-a-table-preference-for-a-given-table
  "Creates a table preference for a given table"
  :POST
  "/api/users/%s/table_preferences"
  user-id)

(defapi updates-a-table-preference-for-a-given-table
  "Updates a table preference for a given table"
  :PUT
  "/api/users/%s/table_preferences/%s"
  user-id name)

(defapi delete-a-table-preference-for-a-given-table
  "Delete a table preference for a given table"
  :DELETE
  "/api/users/%s/table_preferences/%s"
  user-id name)

(defapi list-all-tasks-for-a-given-orchestration-event
  "List all tasks for a given orchestration event"
  :GET
  "/api/orchestration/%s/tasks"
  id)

(defapi list-template-combination
  "List template combination"
  :GET
  "/api/provisioning_templates/%s/template_combinations"
  provisioning-template-id)

(defapi list-template-combination
  "List template combination"
  :GET
  "/api/hostgroups/%s/template_combinations"
  hostgroup-id)

(defapi list-template-combination
  "List template combination"
  :GET
  "/api/environments/%s/template_combinations"
  environment-id)

(defapi add-a-template-combination
  "Add a template combination"
  :POST
  "/api/provisioning_templates/%s/template_combinations"
  provisioning-template-id)

(defapi add-a-template-combination
  "Add a template combination"
  :POST
  "/api/hostgroups/%s/template_combinations"
  hostgroup-id)

(defapi add-a-template-combination
  "Add a template combination"
  :POST
  "/api/environments/%s/template_combinations"
  environment-id)

(defapi show-template-combination
  "Show template combination"
  :GET
  "/api/template_combinations/%s"
  id)

(defapi show-template-combination
  "Show template combination"
  :GET
  "/api/provisioning_templates/%s/template_combinations/%s"
  provisioning-template-id id)

(defapi show-template-combination
  "Show template combination"
  :GET
  "/api/hostgroups/%s/template_combinations/%s"
  hostgroup-id id)

(defapi show-template-combination
  "Show template combination"
  :GET
  "/api/environments/%s/template_combinations/%s"
  environment-id id)

(defapi update-template-combination
  "Update template combination"
  :PUT
  "/api/provisioning_templates/%s/template_combinations/%s"
  provisioning-template-id id)

(defapi update-template-combination
  "Update template combination"
  :PUT
  "/api/hostgroups/%s/template_combinations/%s"
  hostgroup-id id)

(defapi update-template-combination
  "Update template combination"
  :PUT
  "/api/environments/%s/template_combinations/%s"
  environment-id id)

(defapi delete-a-template-combination
  "Delete a template combination"
  :DELETE
  "/api/template_combinations/%s"
  id)

(defapi list-template-inputs
  "List template inputs"
  :GET
  "/api/templates/%s/template_inputs"
  template-id)

(defapi show-template-input-details
  "Show template input details"
  :GET
  "/api/templates/%s/template_inputs/%s"
  template-id id)

(defapi create-a-template-input
  "Create a template input"
  :POST
  "/api/templates/%s/template_inputs"
  template-id)

(defapi delete-a-template-input
  "Delete a template input"
  :DELETE
  "/api/templates/%s/template_inputs/%s"
  template-id id)

(defapi update-a-template-input
  "Update a template input"
  :PUT
  "/api/templates/%s/template_inputs/%s"
  template-id id)

(defapi list-all-template-kinds
  "List all template kinds"
  :GET
  "/api/template_kinds")

(defapi list-of-trends-counters
  "List of trends counters"
  :GET
  "/api/trends")

(defapi show-a-trend
  "Show a trend"
  :GET
  "/api/trends/%s"
  id)

(defapi create-a-trend-counter
  "Create a trend counter"
  :POST
  "/api/trends")

(defapi delete-a-trend-counter
  "Delete a trend counter"
  :DELETE
  "/api/trends/%s"
  id)

(defapi list-all-user-groups
  "List all user groups"
  :GET
  "/api/usergroups")

(defapi show-a-user-group
  "Show a user group"
  :GET
  "/api/usergroups/%s"
  id)

(defapi create-a-user-group
  "Create a user group"
  :POST
  "/api/usergroups")

(defapi update-a-user-group
  "Update a user group"
  :PUT
  "/api/usergroups/%s"
  id)

(defapi delete-a-user-group
  "Delete a user group"
  :DELETE
  "/api/usergroups/%s"
  id)

(defapi list-all-users
  "List all users"
  :GET
  "/api/users")

(defapi list-all-users-for-ldap-authentication-source
  "List all users for LDAP authentication source"
  :GET
  "/api/auth_source_ldaps/%s/users"
  auth-source-ldap-id)

(defapi list-all-users-for-external-authentication-source
  "List all users for external authentication source"
  :GET
  "/api/auth_source_externals/%s/users"
  auth-source-external-id)

(defapi list-all-users-for-user-group
  "List all users for user group"
  :GET
  "/api/usergroups/%s/users"
  usergroup-id)

(defapi list-all-users-for-role
  "List all users for role"
  :GET
  "/api/roles/%s/users"
  role-id)

(defapi list-all-users-for-location
  "List all users for location"
  :GET
  "/api/locations/%s/users"
  location-id)

(defapi list-all-users-for-organization
  "List all users for organization"
  :GET
  "/api/organizations/%s/users"
  organization-id)

(defapi show-a-user
  "Show a user"
  :GET
  "/api/users/%s"
  id)

(defapi create-a-user
  "Create a user"
  :POST
  "/api/users")

(defapi update-a-user
  "Update a user"
  :PUT
  "/api/users/%s"
  id)

(defapi delete-a-user
  "Delete a user"
  :DELETE
  "/api/users/%s"
  id)
