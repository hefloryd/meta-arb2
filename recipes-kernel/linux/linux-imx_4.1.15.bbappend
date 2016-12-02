FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://defconfig"
SRC_URI += "file://0001-arb2-add-board.patch"
SRC_URI += "file://0002-arb2-strip-device-tree.patch"
SRC_URI += "file://0003-arb2-enable-pcie_bus-clock-in-EP_RC_SYS-mode-also.patch"

DO_CONFIG_V7_COPY = "no"
DO_CONFIG_V7_COPY_mx6 = "no"
DO_CONFIG_V7_COPY_mx6ul = "no"
DO_CONFIG_V7_COPY_mx7 = "no"

