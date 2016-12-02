DESCRIPTION = "ARB2 base image"
IMAGE_INSTALL = "packagegroup-core-boot packagegroup-machine-base pciutils imx-test ${ROOTFS_PKGMANAGE_BOOTSTRAP}"
inherit core-image

# NOTE: this function runs twice, once after building the rootfs
# initially, then once again after the kernel has bundled the
# initramfs, if initramfs was wanted, so always test for existence of
# files first.
srec () {
   if [ -e ${DEPLOY_DIR_IMAGE}/u-boot-arb2.imx ]; then
      ${CROSS_COMPILE}objcopy \
        --change-addresses 0x08001000 -I binary -O srec \
	${DEPLOY_DIR_IMAGE}/u-boot-arb2.imx \
	${DEPLOY_DIR_IMAGE}/u-boot-arb2.imx.srec
   fi
   if [ -e ${DEPLOY_DIR_IMAGE}/zImage-imx6dl-arb2.dtb ]; then
      ${CROSS_COMPILE}objcopy \
        --change-addresses 0x080E0000 -I binary -O srec \
	${DEPLOY_DIR_IMAGE}/zImage-imx6dl-arb2.dtb \
	${DEPLOY_DIR_IMAGE}/zImage-imx6dl-arb2.dtb.srec
   fi
   if [ -e ${DEPLOY_DIR_IMAGE}/zImage-initramfs-arb2.bin ]; then
      ${CROSS_COMPILE}objcopy \
        --change-addresses 0x08100000 -I binary -O srec \
	${DEPLOY_DIR_IMAGE}/zImage-initramfs-arb2.bin \
	${DEPLOY_DIR_IMAGE}/zImage-initramfs-arb2.bin.srec
   fi
}

IMAGE_POSTPROCESS_COMMAND += "srec; "
