DESCRIPTION = "A console-only image with more full-featured Linux system \
functionality installed."

SRC_URI = "file://${FILE_DIRNAME}/${BPN}.wks"

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    initscripts-readonly-rootfs-overlay \
    "

IMAGE_FSTYPES = "wic"

inherit core-image

WKS_FILE = "my-image-wic.wks"

WKS_FILE_DEPENDS = "dosfstools-native mtools-native gptfdisk-native squashfs-tools-native"
WKS_FILE_DEPENDS_append_x86 = " syslinux-native syslinux"
WKS_FILE_DEPENDS_append_x86-64 = " syslinux-native syslinux"
WKS_FILE_DEPENDS_append_x86-x32 = " syslinux-native syslinux"

QB_KERNEL_CMDLINE_APPEND += "root=/dev/vda1 rootrw=/dev/vda2 rootrwoptions=rw,noatime init=/init"
QB_DEFAULT_FSTYPE = "wic"
QB_FSINFO = "wic:no-kernel-in-fs"
#QB_KERNEL_ROOT = "/dev/vda1"
