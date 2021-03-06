#
# SPDX-License-Identifier: MIT
# Copyright (c) 2018-2020 Tano Systems LLC. All rights reserved.
#

# SDK paths and names
SDK_NAME_PREFIX = "tanowrt"
SDK_VERSION = "${DISTRO_VERSION}"
SDK_VENDOR = "-tano"
SDK_NAME = "${SDK_NAME_PREFIX}-${SDK_VERSION}"
SDKPATH_REAL ?= "/usr/local/${SDK_NAME_PREFIX}-${SDK_VERSION}"
SDKPATH ?= "${@"/tmp/"+"x"*96+"/"+"y"*96}"
