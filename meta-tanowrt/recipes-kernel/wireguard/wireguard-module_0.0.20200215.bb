require wireguard.inc

SRC_URI = "https://git.zx2c4.com/wireguard-linux-compat/snapshot/wireguard-linux-compat-${PV}.tar.xz"
SRC_URI[md5sum] = "f599d811071b51d69984eb6aa99ab467"
SRC_URI[sha256sum] = "0def6f3608ec06f6dfc454aa5281a7c38b06ff27096cb341448d20602da4e923"

S = "${WORKDIR}/wireguard-linux-compat-${PV}/src"

inherit module kernel-module-split

DEPENDS = "virtual/kernel libmnl"

# This module requires Linux 3.10 higher and several networking related
# configuration options. For exact kernel requirements visit:
# https://www.wireguard.io/install/#kernel-requirements

EXTRA_OEMAKE_append = " \
    KERNELDIR=${STAGING_KERNEL_DIR} \
    "

MAKE_TARGETS = "module"

RRECOMMENDS_${PN} = "kernel-module-xt-hashlimit"
MODULE_NAME = "wireguard"

# Kernel module packages MUST begin with 'kernel-module-', otherwise
# multilib image generation can fail.
#
# The following line is only necessary if the recipe name does not begin
# with kernel-module-.
PKG_${PN} = "kernel-module-${MODULE_NAME}"

module_do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/${MODULE_NAME}
    install -m 0644 ${MODULE_NAME}.ko \
    ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/${MODULE_NAME}/${MODULE_NAME}.ko
}

KERNEL_MODULE_AUTOLOAD += "wireguard"