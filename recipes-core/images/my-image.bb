DESCRIPTION = "A console-only image with more full-featured Linux system \
functionality installed."

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    initscripts-readonly-rootfs-overlay \
    "

inherit image_types_custom core-image

IMAGE_FSTYPES = "rosquashfs_rwext4"

QB_KERNEL_CMDLINE_APPEND += "root=/dev/vda rootrw=/dev/vdb rootrwoptions=rw,noatime init=/init"
QB_OPT_APPEND += "-drive file=${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ext4,if=virtio,format=raw"
QB_DEFAULT_FSTYPE = "rosquashfs_rwext4"
