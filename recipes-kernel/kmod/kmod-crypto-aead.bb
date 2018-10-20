# Copyright (C) 2018 Anton Kikin <a.kikin@tano-systems.com>

PR = "tano0"
SUMMARY = "CryptoAPI AEAD support"
LICENSE = "MIT"

inherit kernel-config-depends

RDEPENDS_${PN} += "\
	kmod-crypto-null \
"

#
# kmod-crypto-aead
# ######################
#
KERNEL_CONFIG_DEPENDS += "{\
	option              = CONFIG_CRYPTO_AEAD2, \
	required            = y|m, \
	m_rdepends          = kernel-module-aead, \
	m_autoload          = aead, \
	m_autoload_early    = true, \
	m_autoload_priority = 9, \
	m_autoload_script   = crypto-aead \
}"

KERNEL_CONFIG_DEPENDS += "{\
	option              = CONFIG_CRYPTO_AEAD, \
	required            = y|m \
}"
