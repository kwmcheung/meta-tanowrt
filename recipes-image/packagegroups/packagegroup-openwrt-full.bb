# Copyright (C) 2015 Khem Raj <raj.khem@gmail.com>
# Copyright (C) 2018 Daniel Dickinson <cshored@thecshore.com>
# Copyright (C) 2018 Anton Kikin <a.kikin@tano-systems.com>

# Released under the MIT license (see COPYING.MIT for the terms)

PR = "tano2"
SUMMARY = "Extras Openwrt system requirements"
LICENSE = "MIT"

inherit packagegroup openwrt

PACKAGES = "\
	packagegroup-openwrt-full \
	packagegroup-openwrt-full-base \
	packagegroup-openwrt-full-network \
	packagegroup-openwrt-full-luci \
"

RDEPENDS_${PN} = "\
	packagegroup-openwrt-base \
	packagegroup-openwrt-full-network \
	packagegroup-openwrt-full-luci \
	fstools \
	eudev \
	${@bb.utils.contains('DISTRO_FEATURES', 'usbhost', 'libusb1', '',d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'usbhost', 'usbutils', '',d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'usbhost', 'usbreset', '',d)} \
	mtd-utils \
	mtd-utils-ubifs \
	apcupsd \
"

RDEPENDS_${PN}-luci = "\
	luci-app-lldpd \
	luci-app-mstpd \
	luci-app-commands \
	luci-app-uhttpd \
	luci-app-openvpn \
	luci-app-ddns \
	luci-app-terminal \
	luci-proto-3g \
	luci-proto-ncm \
	luci-proto-ppp \
	luci-proto-qmi \
"

RDEPENDS_${PN}-network = "\
	relayd \
	tcpdump \
	umbim \
	umdnsd \
	ethtool \
	dropbear \
	openssh-sftp-server \
	net-snmp-client \
	net-snmp-mibs \
	net-snmp-server-snmpd \
	net-snmp-server-snmptrapd \
	openvpn \
	openvpn-easy-rsa \
	lldpd \
	vsftpd \
	mstpd \
"
