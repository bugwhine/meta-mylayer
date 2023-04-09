inherit image_types

IMAGE_CMD_rosquashfs_rwext4 () {
    #ro-rootfs
    mksquashfs ${IMAGE_ROOTFS} ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.rosquashfs_rwext4 ${EXTRA_IMAGECMD} -noappend

    #empty rw-overlay
	dd if=/dev/zero of=${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ext4 count=100 bs=1M
	mkfs.ext4 ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ext4
	fsck.ext4 -pvfD ${IMGDEPLOYDIR}/${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.ext4 || [ $? -le 3 ]
}
