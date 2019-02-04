# meta-tano-openwrt

This layer provides OpenEmbedded metadata for TanoWrt Linux distribution by Tano Systems. TanoWrt distribution is based on packages and fixes (patches) from the official [OpenWrt](https://openwrt.org/) distribution.

Some configuration files, scripts, patches and other files for OpenWrt packages, including descriptions in recipe files, are taken from the official OpenWrt repositories:
- https://github.com/openwrt/openwrt.git --- buildsystem for the OpenWrt Linux distribution;
- https://github.com/openwrt/packages.git --- OpenWrt packages feed.

This layer is initially based on a OE metadata layer for OpenWrt by [Khem Raj](https://github.com/kraj/meta-openwrt) (revision [3f94c4f5aa965aa5d65419d6691b40a3870e84a8](https://github.com/kraj/meta-openwrt/commit/3f94c4f5aa965aa5d65419d6691b40a3870e84a8))

Most OpenWrt packages corresponds to OpenWrt 18.06.2 or higher.

## Getting Started

Clone repositories:
```
$ git clone -b sumo git://github.com/openembedded/openembedded-core.git

$ cd openembedded-core

$ git clone -b 1.38 git://github.com/openembedded/bitbake.git
$ git clone -b sumo git://github.com/openembedded/meta-openembedded.git
$ git clone -b sumo git://github.com/tano-systems/meta-tano-openwrt.git
```

Initialize build environment and add layers:
```
$ TEMPLATECONF=meta-tano-openwrt/conf . ./oe-init-build-env
```

## Building

Below we build for qemuarm machine as an example:
```
MACHINE=qemuarm bitbake openwrt-image-full
```


## Running

```
runqemu qemuarm
```

## Limitations

Works with OE Release 2.5 (Sumo)

Images are buildable/bootable for arm, x86 and x86_64 based qemu machines MACHINE variable.

## Dependencies

This layer depends on:

### openembedded-core
URI: git://git.openembedded.org/openembedded-core.git  
Subdirectory: meta  
Branch: sumo  
Revision: 84f19e78d9b1f3d634cf1d46ce48f24670199d0b

### meta-openembedded
URI: git://git.openembedded.org/meta-openembedded.git  
Subdirectory: meta-oe  
Branch: sumo  
Revision: 8760facba1bceb299b3613b8955621ddaa3d4c3f

### meta-python
URI: git://git.openembedded.org/meta-openembedded.git  
Subdirectory: meta-python  
Branch: sumo  
Revision: 8760facba1bceb299b3613b8955621ddaa3d4c3f

### meta-networking
URI: git://git.openembedded.org/meta-openembedded.git  
Subdirectory: meta-networking  
Branch: sumo  
Revision: 8760facba1bceb299b3613b8955621ddaa3d4c3f

### bitbake
URI: git://git.openembedded.org/bitbake  
Branch: 1.38  
Revision: c0af6c81f8d5487ea2cef54a78fd1cb1d0dc6520


## License

All metadata is MIT licensed unless otherwise stated. Source code included
in tree for individual recipes is under the LICENSE stated in each recipe
(.bb file) unless otherwise stated.

## Maintainers

Anton Kikin <a.kikin@tano-systems.com>
