#
# SPDX-License-Identifier: MIT
#
# Copyright (C) 2018 Daniel Dickinson <cshored@thecshore.com>
# Copyright (C) 2018-2021 Anton Kikin <a.kikin@tano-systems.com>
#

SUMMARY = "OpenWrt DHCPv6 client"
HOMEPAGE = "http://git.openwrt.org/?p=project/odhcp63.git;a=summary"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://src/odhcp6c.c;beginline=1;endline=13;md5=41d01a2c8e6a8ef58b8e5f18e68118a8"
SECTION = "base"
DEPENDS = "libubox"
PR = "tano6"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/patches:${THISDIR}/${PN}/files:"

# 26.12.2020
# dhcpv6: fix displaying IA info
SRCREV = "eac1961983b8e7a74c494feedcb878170b135072"

SRC_URI = "\
	git://${GIT_OPENWRT_ORG}/project/odhcp6c.git;name=odhcp6c \
	file://dhcpv6.script \
	file://dhcpv6.sh \
"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

SRCREV_openwrt = "${OPENWRT_SRCREV}"

do_install_append() {
	install -Dm 0755 ${WORKDIR}/dhcpv6.sh ${D}${base_libdir}/netifd/proto/dhcpv6.sh
	install -Dm 0755 ${WORKDIR}/dhcpv6.script ${D}${base_libdir}/netifd/dhcpv6.script
}

FILES_${PN} += "\
	${base_libdir}/netifd/proto/dhcpv6.sh \
	${base_libdir}/netifd/dhcpv6.script \
"

RRECOMMENDS_${PN} += "netifd"
