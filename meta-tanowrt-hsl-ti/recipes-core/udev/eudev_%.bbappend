# This file Copyright (C) 2019-2020 Anton Kikin <a.kikin@tano-systems.com>

PR_append_ti33x = ".ti2"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/files:"

RRECOMMENDS_${PN}_remove = "eudev-hwdb"

do_install_append_ti33x() {
	rm -f ${D}${sysconfdir}/udev/rules.d/firmware.rules
}
