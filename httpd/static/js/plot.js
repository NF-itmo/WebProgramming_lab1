const convertInputCordsToSvgCords = (
    X, Y, R,
    paddingX = 20,
    paddingY = 20,
    XAxisSize = 160,
    YAxisSize = 160
) => {
    return [paddingX + (1 + X/R)*XAxisSize/2, paddingY + (1 - Y/R)*YAxisSize/2];
}


class Plot {
    #svgNamespace = "http://www.w3.org/2000/svg";
    #container;

    constructor(svgId) {
        this.#container = document.getElementById(svgId);
    }

    addPoint(cx, cy, radius, styleClass) {
        const point = document.createElementNS(this.#svgNamespace, 'circle');    

        point.setAttributeNS(null, 'cx', cx);
        point.setAttributeNS(null, 'cy', cy);
        point.setAttributeNS(null, 'r', radius);
        point.setAttributeNS(null, 'class', styleClass); 

        this.#container.appendChild(point);
    } 

    clear() {
        this.#container.querySelectorAll('circle').forEach((elem) => {
            elem.remove();
        });
    }

}