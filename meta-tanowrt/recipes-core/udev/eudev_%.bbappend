# Copyright (C) 2015 Khem Raj <raj.khem@gmail.com>
# Copyright (C) 2018-2019 Anton Kikin <a.kikin@tano-systems.com>

# Released under the MIT license (see COPYING.MIT for the terms)

PR_append = ".tano9"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/patches:${THISDIR}/${PN}/files:"

SRC_URI += "file://udev.init file://local.rules file://openwrt-hotplug.rules"

inherit openwrt-services
inherit useradd

RRECOMMENDS_${PN}_remove = "eudev-hwdb"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "\
    -f -r tty; \
    -f -r dialout; \
    -f -r kmem; \
    -f -r input; \
    -f -r video; \
    -f -r lp; \
    -f -r disk; \
    -f -r cdrom; \
    -f -r tape; \
    -f -r floppy; \
    -f -r kvm;"

OPENWRT_SERVICE_PACKAGES = "eudev"
OPENWRT_SERVICE_SCRIPTS_eudev += "udev"
OPENWRT_SERVICE_STATE_eudev-udev ?= "enabled"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/udev.init ${D}${sysconfdir}/init.d/udev

    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/local.rules ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/openwrt-hotplug.rules ${D}${sysconfdir}/udev/rules.d
}
